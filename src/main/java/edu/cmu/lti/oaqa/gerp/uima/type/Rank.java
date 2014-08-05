

/* First created by JCasGen Mon Jul 28 16:36:39 EDT 2014 */
package edu.cmu.lti.oaqa.gerp.uima.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** A type represents the rank for the candidate entities, which is normally done by a ranker's synthesized analysis of collected evidences.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * XML source: /home/yangzi/QA/gerp/src/main/resources/edu/cmu/lti/oaqa/gerp/uima/GerpTypes.xml
 * @generated */
public class Rank extends GerpBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Rank.class);
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
  protected Rank() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Rank(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Rank(JCas jcas) {
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
  //* Feature: ranker

  /** getter for ranker - gets A ranker name that ranks the raw type.
   * @generated
   * @return value of the feature 
   */
  public String getRanker() {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_ranker == null)
      jcasType.jcas.throwFeatMissing("ranker", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Rank_Type)jcasType).casFeatCode_ranker);}
    
  /** setter for ranker - sets A ranker name that ranks the raw type. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRanker(String v) {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_ranker == null)
      jcasType.jcas.throwFeatMissing("ranker", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    jcasType.ll_cas.ll_setStringValue(addr, ((Rank_Type)jcasType).casFeatCode_ranker, v);}    
   
    
  //*--------------*
  //* Feature: rank

  /** getter for rank - gets A non-negative integer represents the rank of candidate.
   * @generated
   * @return value of the feature 
   */
  public int getRank() {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Rank_Type)jcasType).casFeatCode_rank);}
    
  /** setter for rank - sets A non-negative integer represents the rank of candidate. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRank(int v) {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    jcasType.ll_cas.ll_setIntValue(addr, ((Rank_Type)jcasType).casFeatCode_rank, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets A float value represents how likely the candidate is relevant. The value is not required to have a probabilistic interpretation, instead any similarity, distance, etc. can be used.
   * @generated
   * @return value of the feature 
   */
  public double getScore() {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Rank_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets A float value represents how likely the candidate is relevant. The value is not required to have a probabilistic interpretation, instead any similarity, distance, etc. can be used. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setScore(double v) {
    if (Rank_Type.featOkTst && ((Rank_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Rank_Type)jcasType).casFeatCode_score, v);}    
  }

    