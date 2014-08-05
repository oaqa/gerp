package edu.cmu.lti.oaqa.gerp.util;

public final class Pair<K, V> {

  private final K key;

  private final V value;

  private Pair(K key, V value) {
    super();
    this.key = key;
    this.value = value;
  }

  public static <K, V> Pair<K, V> of(K key, V value) {
    return new Pair<K, V>(key, value);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    return true;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

}
