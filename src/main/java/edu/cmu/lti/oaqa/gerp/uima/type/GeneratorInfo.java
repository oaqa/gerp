

/* First created by JCasGen Mon Jul 28 16:36:39 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;


/** A type that stores the information of the generator that creates the type.
 * Updated by JCasGen Mon Sep 08 15:43:53 EDT 2014
 * XML source: /home/yangzi/QA/gerp/src/main/resources/edu/cmu/lti/oaqa/gerp/uima/GerpTypes.xml
 * @generated */
public class GeneratorInfo extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneratorInfo.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneratorInfo() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GeneratorInfo(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GeneratorInfo(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: generator

  /** getter for generator - gets Genenator name that nominees this feature structure to be the candidate of a certain targeted entity.
   * @generated
   * @return value of the feature 
   */
  public String getGenerator() {
    if (GeneratorInfo_Type.featOkTst && ((GeneratorInfo_Type)jcasType).casFeat_generator == null)
      jcasType.jcas.throwFeatMissing("generator", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneratorInfo_Type)jcasType).casFeatCode_generator);}
    
  /** setter for generator - sets Genenator name that nominees this feature structure to be the candidate of a certain targeted entity. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setGenerator(String v) {
    if (GeneratorInfo_Type.featOkTst && ((GeneratorInfo_Type)jcasType).casFeat_generator == null)
      jcasType.jcas.throwFeatMissing("generator", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneratorInfo_Type)jcasType).casFeatCode_generator, v);}    
   
    
  //*--------------*
  //* Feature: dependencies

  /** getter for dependencies - gets The pointers to the inputs that are being used to generate the Top.
   * @generated
   * @return value of the feature 
   */
  public FSList getDependencies() {
    if (GeneratorInfo_Type.featOkTst && ((GeneratorInfo_Type)jcasType).casFeat_dependencies == null)
      jcasType.jcas.throwFeatMissing("dependencies", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GeneratorInfo_Type)jcasType).casFeatCode_dependencies)));}
    
  /** setter for dependencies - sets The pointers to the inputs that are being used to generate the Top. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDependencies(FSList v) {
    if (GeneratorInfo_Type.featOkTst && ((GeneratorInfo_Type)jcasType).casFeat_dependencies == null)
      jcasType.jcas.throwFeatMissing("dependencies", "edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo");
    jcasType.ll_cas.ll_setRefValue(addr, ((GeneratorInfo_Type)jcasType).casFeatCode_dependencies, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    