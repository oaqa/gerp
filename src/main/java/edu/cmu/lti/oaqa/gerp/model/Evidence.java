package edu.cmu.lti.oaqa.gerp.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public final class Evidence {

  private final double confidence;

  private final List<?> details;

  private Evidence(double confidence, List<?> details) {
    super();
    this.confidence = confidence;
    this.details = details;
  }

  public static Evidence create(double confidence) {
    return new Evidence(confidence, new ArrayList<>());
  }

  public static Evidence createWithDetail(double confidence, Object detail) {
    List<Object> details = new ArrayList<>();
    details.add(detail);
    return new Evidence(confidence, details);
  }

  public static Evidence createWithDetails(double confidence, List<?> details) {
    return new Evidence(confidence, details);
  }

  private static DecimalFormat df = new DecimalFormat("0.0000");
  
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer(df.format(confidence));
    if (!details.isEmpty()) {
      sb.append(" " + details.toString());
    }
    return sb.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(confidence);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((details == null) ? 0 : details.hashCode());
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
    Evidence other = (Evidence) obj;
    if (Double.doubleToLongBits(confidence) != Double.doubleToLongBits(other.confidence))
      return false;
    if (details == null) {
      if (other.details != null)
        return false;
    } else if (!details.equals(other.details))
      return false;
    return true;
  }

  public double getConfidence() {
    return confidence;
  }

  public List<?> getAdditionalEvidences() {
    return details;
  }

}
