package edu.cmu.lti.oaqa.gerp.uima.util;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.FeatureStructureImpl;
import org.apache.uima.fit.util.CasUtil;
import org.apache.uima.util.CasCopier;

public class CasMerger {

  private CAS origCas;

  private CasCopier copier;

  public CasMerger(CAS forkedCas, CAS origCas) {
    this.origCas = origCas;
    this.copier = new CasCopier(forkedCas, origCas, true);
  }

  public static void mergeJCas(CAS forkedCas, CAS origCas) {
    CasMerger merger = new CasMerger(forkedCas, origCas);
    forkedCas.getViewIterator().forEachRemaining(view -> merger.mergeCasView(view));
  }

  public void mergeCasView(CAS forkedCasView) {
    mergeCasView(forkedCasView, getOrCreateView(origCas, forkedCasView.getViewName()));
  }

  private void mergeCasView(CAS forkedCasView, CAS origCasView) {
    Map<Integer, FeatureStructure> origFsAddrMap = CasUtil.selectAllFS(origCasView).stream()
            .filter(fs -> fs instanceof FeatureStructureImpl).map(fs -> (FeatureStructureImpl) fs)
            .collect(Collectors.toMap(FeatureStructureImpl::getAddress, Function.identity()));
    CasUtil.selectAllFS(forkedCasView).forEach(
            forkedFs -> {
              FeatureStructure origOrCopiedFs = copyAndIndexFsIfNotInOrigCas(forkedFs, origCasView,
                      origFsAddrMap);
              mergeFs(forkedFs, origOrCopiedFs);
            });
  }

  private FeatureStructure getOrigFsOfSameAddr(FeatureStructure forkedFs,
          Map<Integer, FeatureStructure> origFsAddrMap) {
    int forkedFsAddr = getFsAddr(forkedFs);
    if (origFsAddrMap.containsKey(forkedFsAddr)) {
      FeatureStructure origFs = origFsAddrMap.get(forkedFsAddr);
      assert origFs.getClass().equals(forkedFs.getClass());
      return origFs;
    }
    return null;
  }

  private FeatureStructure copyAndIndexFsIfNotInOrigCas(FeatureStructure forkedFs, CAS origCasView,
          Map<Integer, FeatureStructure> origFsAddrMap) {
    // CAS copying is needed by the feature structure address exists in the original view.
    FeatureStructure origOrCopiedFs;
    if ((origOrCopiedFs = getOrigFsOfSameAddr(forkedFs, origFsAddrMap)) == null) {
      origOrCopiedFs = copier.copyFs(forkedFs);
      origCasView.addFsToIndexes(origOrCopiedFs);
    }
    return origOrCopiedFs;
  }

  private int getFsAddr(FeatureStructure fs) {
    // A weird case: a feature structure does not extend FeatureStructureImpl.
    // As of version 2.6, all FeatureStructure from the API do inherit FeatureStructureImpl, which
    // means this should never happen.
    if (!(fs instanceof FeatureStructureImpl)) {
      throw new UnsupportedOperationException();
    }
    // "Normal" FeatureStructures can be retrieved by address
    return ((FeatureStructureImpl) fs).getAddress();
  }

  private void mergeFs(FeatureStructure forkedFs, FeatureStructure origOrCopiedFs) {
    // Iterate over all features and if the feature structures referenced by forkedFs exist in
    // origFs, existing features values will be used, otherwise create new.
    forkedFs.getType().getFeatures().forEach(feat -> {
      FeatureStructure forkedSubFs = forkedFs.getFeatureValue(feat);
      FeatureStructure origOrCopiedSubFs = origOrCopiedFs.getFeatureValue(feat);
      mergeFs(forkedSubFs, origOrCopiedSubFs);
      origOrCopiedFs.setFeatureValue(feat, origOrCopiedSubFs);
    });
    // Check if FS branch merge is needed
    
  }

  private static CAS getOrCreateView(CAS cas, String viewName) {
    try {
      return cas.getView(viewName);
    } catch (CASRuntimeException e) {
      return cas.createView(viewName);
    }
  }

}
