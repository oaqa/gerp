package edu.cmu.lti.oaqa.gerp.model;

import java.text.DecimalFormat;

public final class Rank {

  private final int rank;
  
  private final double score;

  private Rank(int rank, double score) {
    super();
    this.rank = rank;
    this.score = score;
  }
  
  public static Rank create(int rank) {
    return new Rank(rank, Double.NaN);
  }
  
  public static Rank createWithScore(int rank, double score) {
    return new Rank(rank, score);
  }

  private static DecimalFormat df = new DecimalFormat("0.0000");
  
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer(String.valueOf(rank));
    if (!Double.isNaN(score)) {
      sb.append(" [" + df.format(score) + "]");
    }
    return sb.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + rank;
    long temp;
    temp = Double.doubleToLongBits(score);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Rank other = (Rank) obj;
    if (rank != other.rank)
      return false;
    if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
      return false;
    return true;
  }

  public int getRank() {
    return rank;
  }

  public double getScore() {
    return score;
  }

}
