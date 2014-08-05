

/* First created by JCasGen Mon Jul 28 16:36:39 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;


/** A type represents the evidence for the candidate entities, which is provided by an evidencer.
 * Updated by JCasGen Fri Aug 01 22:08:41 EDT 2014
 * XML source: /home/yangzi/QA/gerp/src/main/resources/edu/cmu/lti/oaqa/gerp/uima/GerpTypes.xml
 * @generated */
public class Evidence extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Evidence.class);
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
  protected Evidence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Evidence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Evidence(JCas jcas) {
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
  //* Feature: evidencer

  /** getter for evidencer - gets An evidencer name that evidences the raw type.
   * @generated
   * @return value of the feature 
   */
  public String getEvidencer() {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_evidencer == null)
      jcasType.jcas.throwFeatMissing("evidencer", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Evidence_Type)jcasType).casFeatCode_evidencer);}
    
  /** setter for evidencer - sets An evidencer name that evidences the raw type. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setEvidencer(String v) {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_evidencer == null)
      jcasType.jcas.throwFeatMissing("evidencer", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Evidence_Type)jcasType).casFeatCode_evidencer, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets A score that indicates how likely the evidencer estimates the entity is qualified for the task.
   * @generated
   * @return value of the feature 
   */
  public double getConfidence() {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Evidence_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets A score that indicates how likely the evidencer estimates the entity is qualified for the task. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Evidence_Type)jcasType).casFeatCode_confidence, v);}    
   
    
  //*--------------*
  //* Feature: details

  /** getter for details - gets Detailed evidences provided by the evidencer in addition to the confidence score, e.g. related document URIs where a text similarity based evidence is calculated.
   * @generated
   * @return value of the feature 
   */
  public FSList getDetails() {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_details == null)
      jcasType.jcas.throwFeatMissing("details", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Evidence_Type)jcasType).casFeatCode_details)));}
    
  /** setter for details - sets Detailed evidences provided by the evidencer in addition to the confidence score, e.g. related document URIs where a text similarity based evidence is calculated. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDetails(FSList v) {
    if (Evidence_Type.featOkTst && ((Evidence_Type)jcasType).casFeat_details == null)
      jcasType.jcas.throwFeatMissing("details", "edu.cmu.lti.oaqa.gerp.uima.type.Evidence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Evidence_Type)jcasType).casFeatCode_details, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    