
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

/** A type represents the evidence for the candidate entities, which is provided by an evidencer.
 * Updated by JCasGen Fri Aug 01 22:08:41 EDT 2014
 * @generated */
public class Evidence_Type extends GerpBase_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Evidence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Evidence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Evidence(addr, Evidence_Type.this);
  			   Evidence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Evidence(addr, Evidence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Evidence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
 
  /** @generated */
  final Feature casFeat_evidencer;
  /** @generated */
  final int     casFeatCode_evidencer;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getEvidencer(int addr) {
        if (featOkTst && casFeat_evidencer == null)
      jcas.throwFeatMissing("evidencer", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_evidencer);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEvidencer(int addr, String v) {
        if (featOkTst && casFeat_evidencer == null)
      jcas.throwFeatMissing("evidencer", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    ll_cas.ll_setStringValue(addr, casFeatCode_evidencer, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_details;
  /** @generated */
  final int     casFeatCode_details;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDetails(int addr) {
        if (featOkTst && casFeat_details == null)
      jcas.throwFeatMissing("details", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_details);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDetails(int addr, int v) {
        if (featOkTst && casFeat_details == null)
      jcas.throwFeatMissing("details", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    ll_cas.ll_setRefValue(addr, casFeatCode_details, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Evidence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_evidencer = jcas.getRequiredFeatureDE(casType, "evidencer", "uima.cas.String", featOkTst);
    casFeatCode_evidencer  = (null == casFeat_evidencer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_evidencer).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

 
    casFeat_details = jcas.getRequiredFeatureDE(casType, "details", "uima.cas.FSList", featOkTst);
    casFeatCode_details  = (null == casFeat_details) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_details).getCode();

  }
}



    