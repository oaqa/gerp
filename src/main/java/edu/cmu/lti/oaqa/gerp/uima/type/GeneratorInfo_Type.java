
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

/** A type that stores the information of the generator that creates the type.
 * Updated by JCasGen Mon Sep 08 15:43:53 EDT 2014
 * @generated */
public class GeneratorInfo_Type extends GerpBase_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneratorInfo_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneratorInfo_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneratorInfo(addr, GeneratorInfo_Type.this);
  			   GeneratorInfo_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneratorInfo(addr, GeneratorInfo_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneratorInfo.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
 
  /** @generated */
  final Feature casFeat_generator;
  /** @generated */
  final int     casFeatCode_generator;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGenerator(int addr) {
        if (featOkTst && casFeat_generator == null)
      jcas.throwFeatMissing("generator", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    return ll_cas.ll_getStringValue(addr, casFeatCode_generator);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGenerator(int addr, String v) {
        if (featOkTst && casFeat_generator == null)
      jcas.throwFeatMissing("generator", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    ll_cas.ll_setStringValue(addr, casFeatCode_generator, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dependencies;
  /** @generated */
  final int     casFeatCode_dependencies;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDependencies(int addr) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dependencies);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDependencies(int addr, int v) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    ll_cas.ll_setRefValue(addr, casFeatCode_dependencies, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GeneratorInfo_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_generator = jcas.getRequiredFeatureDE(casType, "generator", "uima.cas.String", featOkTst);
    casFeatCode_generator  = (null == casFeat_generator) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_generator).getCode();

 
    casFeat_dependencies = jcas.getRequiredFeatureDE(casType, "dependencies", "uima.cas.FSList", featOkTst);
    casFeatCode_dependencies  = (null == casFeat_dependencies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dependencies).getCode();

  }
}



    