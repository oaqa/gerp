

/* First created by JCasGen Mon Jul 28 19:50:58 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** The base class for Gerp feature structures.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * XML source: /home/yangzi/QA/gerp/src/main/resources/edu/cmu/lti/oaqa/gerp/uima/GerpTypes.xml
 * @generated */
public class GerpBase extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GerpBase.class);
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
  protected GerpBase() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GerpBase(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GerpBase(JCas jcas) {
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
  //* Feature: raw

  /** getter for raw - gets The pointer to the raw type.
   * @generated
   * @return value of the feature 
   */
  public TOP getRaw() {
    if (GerpBase_Type.featOkTst && ((GerpBase_Type)jcasType).casFeat_raw == null)
      jcasType.jcas.throwFeatMissing("raw", "edu.cmu.lti.oaqa.gerp.uima.type.GerpBase");
    return (TOP)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GerpBase_Type)jcasType).casFeatCode_raw)));}
    
  /** setter for raw - sets The pointer to the raw type. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRaw(TOP v) {
    if (GerpBase_Type.featOkTst && ((GerpBase_Type)jcasType).casFeat_raw == null)
      jcasType.jcas.throwFeatMissing("raw", "edu.cmu.lti.oaqa.gerp.uima.type.GerpBase");
    jcasType.ll_cas.ll_setRefValue(addr, ((GerpBase_Type)jcasType).casFeatCode_raw, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    