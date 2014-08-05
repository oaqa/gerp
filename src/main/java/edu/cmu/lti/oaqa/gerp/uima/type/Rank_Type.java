
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

/** A type represents the rank for the candidate entities, which is normally done by a ranker's synthesized analysis of collected evidences.
 * Updated by JCasGen Fri Aug 01 22:08:42 EDT 2014
 * @generated */
public class Rank_Type extends GerpBase_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Rank_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Rank_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Rank(addr, Rank_Type.this);
  			   Rank_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Rank(addr, Rank_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Rank.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.oaqa.gerp.uima.type.Rank");
 
  /** @generated */
  final Feature casFeat_ranker;
  /** @generated */
  final int     casFeatCode_ranker;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRanker(int addr) {
        if (featOkTst && casFeat_ranker == null)
      jcas.throwFeatMissing("ranker", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ranker);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRanker(int addr, String v) {
        if (featOkTst && casFeat_ranker == null)
      jcas.throwFeatMissing("ranker", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    ll_cas.ll_setStringValue(addr, casFeatCode_ranker, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rank;
  /** @generated */
  final int     casFeatCode_rank;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRank(int addr) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rank);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRank(int addr, int v) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    ll_cas.ll_setIntValue(addr, casFeatCode_rank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "edu.cmu.lti.oaqa.gerp.uima.type.Rank");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Rank_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ranker = jcas.getRequiredFeatureDE(casType, "ranker", "uima.cas.String", featOkTst);
    casFeatCode_ranker  = (null == casFeat_ranker) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ranker).getCode();

 
    casFeat_rank = jcas.getRequiredFeatureDE(casType, "rank", "uima.cas.Integer", featOkTst);
    casFeatCode_rank  = (null == casFeat_rank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rank).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

  }
}



    