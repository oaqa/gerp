package edu.cmu.lti.oaqa.gerp.model;


public final class PruningDecision {

  private final boolean decision;

  private PruningDecision(boolean decision) {
    super();
    this.decision = decision;
  }

  public static PruningDecision create(boolean decision) {
    return new PruningDecision(decision);
  }
  
  public static PruningDecision createTrue() {
    return new PruningDecision(true);
  }
  
  public static PruningDecision createFalse() {
    return new PruningDecision(false);
  }

  @Override
  public String toString() {
    return String.valueOf(decision);
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (decision ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PruningDecision other = (PruningDecision) obj;
    if (decision != other.decision)
      return false;
    return true;
  }

  public boolean isDecision() {
    return decision;
  }

}
 