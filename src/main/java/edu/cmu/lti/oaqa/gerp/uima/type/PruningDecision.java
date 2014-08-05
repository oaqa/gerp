

/* First created by JCasGen Mon Jul 28 16:36:39 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** A type represents the pruning decision for the candidate entities, which is provided by a pruner.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * XML source: /home/yangzi/QA/gerp/src/main/resources/edu/cmu/lti/oaqa/gerp/uima/GerpTypes.xml
 * @generated */
public class PruningDecision extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PruningDecision.class);
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
  protected PruningDecision() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public PruningDecision(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public PruningDecision(JCas jcas) {
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
  //* Feature: pruner

  /** getter for pruner - gets A pruner name that assignes pruning decision the raw type.
   * @generated
   * @return value of the feature 
   */
  public String getPruner() {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_pruner == null)
      jcasType.jcas.throwFeatMissing("pruner", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    return jcasType.ll_cas.ll_getStringValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_pruner);}
    
  /** setter for pruner - sets A pruner name that assignes pruning decision the raw type. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPruner(String v) {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_pruner == null)
      jcasType.jcas.throwFeatMissing("pruner", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    jcasType.ll_cas.ll_setStringValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_pruner, v);}    
   
    
  //*--------------*
  //* Feature: decision

  /** getter for decision - gets A binary pruning decision made by a pruner.
   * @generated
   * @return value of the feature 
   */
  public boolean getDecision() {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_decision == null)
      jcasType.jcas.throwFeatMissing("decision", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_decision);}
    
  /** setter for decision - sets A binary pruning decision made by a pruner. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDecision(boolean v) {
    if (PruningDecision_Type.featOkTst && ((PruningDecision_Type)jcasType).casFeat_decision == null)
      jcasType.jcas.throwFeatMissing("decision", "edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((PruningDecision_Type)jcasType).casFeatCode_decision, v);}    
  }

    