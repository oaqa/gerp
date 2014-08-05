
/* First created by JCasGen Mon Jul 28 16:36:39 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** A type represents the pruning decision for the candidate entities, which is provided by a pruner.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * @generated */
public class PruningDecision_Type extends GerpBase_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (PruningDecision_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = PruningDecision_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new PruningDecision(addr, PruningDecision_Type.this);
  			   PruningDecision_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new PruningDecision(addr, PruningDecision_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PruningDecision.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
 
  /** @generated */
  final Feature casFeat_pruner;
  /** @generated */
  final int     casFeatCode_pruner;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPruner(int addr) {
        if (featOkTst && casFeat_pruner == null)
      jcas.throwFeatMissing("pruner", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pruner);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPruner(int addr, String v) {
        if (featOkTst && casFeat_pruner == null)
      jcas.throwFeatMissing("pruner", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    ll_cas.ll_setStringValue(addr, casFeatCode_pruner, v);}
    
  
 
  /** @generated */
  final Feature casFeat_decision;
  /** @generated */
  final int     casFeatCode_decision;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getDecision(int addr) {
        if (featOkTst && casFeat_decision == null)
      jcas.throwFeatMissing("decision", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_decision);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDecision(int addr, boolean v) {
        if (featOkTst && casFeat_decision == null)
      jcas.throwFeatMissing("decision", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_decision, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public PruningDecision_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pruner = jcas.getRequiredFeatureDE(casType, "pruner", "uima.cas.String", featOkTst);
    casFeatCode_pruner  = (null == casFeat_pruner) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pruner).getCode();

 
    casFeat_decision = jcas.getRequiredFeatureDE(casType, "decision", "uima.cas.Boolean", featOkTst);
    casFeatCode_decision  = (null == casFeat_decision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_decision).getCode();

  }
}



    