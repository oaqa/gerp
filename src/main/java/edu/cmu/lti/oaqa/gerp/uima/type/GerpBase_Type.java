
/* First created by JCasGen Mon Jul 28 19:50:58 EDT 2014 */
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

/** The base class for Gerp feature structures.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * @generated */
public class GerpBase_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GerpBase_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GerpBase_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GerpBase(addr, GerpBase_Type.this);
  			   GerpBase_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GerpBase(addr, GerpBase_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GerpBase.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.gerp.uima.type.GerpBase");
 
  /** @generated */
  final Feature casFeat_raw;
  /** @generated */
  final int     casFeatCode_raw;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRaw(int addr) {
        if (featOkTst && casFeat_raw == null)
      jcas.throwFeatMissing("raw", "edu.cmu.lti.oaqa.gerp.uima.type.GerpBase");
    return ll_cas.ll_getRefValue(addr, casFeatCode_raw);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRaw(int addr, int v) {
        if (featOkTst && casFeat_raw == null)
      jcas.throwFeatMissing("raw", "edu.cmu.lti.oaqa.gerp.uima.type.GerpBase");
    ll_cas.ll_setRefValue(addr, casFeatCode_raw, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GerpBase_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_raw = jcas.getRequiredFeatureDE(casType, "raw", "uima.cas.TOP", featOkTst);
    casFeatCode_raw  = (null == casFeat_raw) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_raw).getCode();

  }
}



    