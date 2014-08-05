package edu.cmu.lti.oaqa.gerp.util;

public final class Triple<K1, K2, V> {

  private final K1 key1;

  private final K2 key2;

  private final V value;

  public Triple(K1 key1, K2 key2, V value) {
    super();
    this.key1 = key1;
    this.key2 = key2;
    this.value = value;
  }

  public static <K1, K2, V> Triple<K1, K2, V> of(K1 key1, K2 key2, V value) {
    return new Triple<K1, K2, V>(key1, key2, value);
  }

  public static <K1, K2, V> Triple<K1, K2, V> of(Pair<K1, K2> keyPair, V value) {
    return new Triple<K1, K2, V>(keyPair.getKey(), keyPair.getValue(), value);
  }

  public static <K1, K2, V> Triple<K1, K2, V> of(K1 key1, Pair<K2, V> key2ValuePair) {
    return new Triple<K1, K2, V>(key1, key2ValuePair.getKey(), key2ValuePair.getValue());
  }

  public Pair<K1, K2> getKeyPair() {
    return Pair.of(key1, key2);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key1 == null) ? 0 : key1.hashCode());
    result = prime * result + ((key2 == null) ? 0 : key2.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
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
    Triple other = (Triple) obj;
    if (key1 == null) {
      if (other.key1 != null)
        return false;
    } else if (!key1.equals(other.key1))
      return false;
    if (key2 == null) {
      if (other.key2 != null)
        return false;
    } else if (!key2.equals(other.key2))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

  public K1 getKey1() {
    return key1;
  }

  public K2 getKey2() {
    return key2;
  }

  public V getValue() {
    return value;
  }

}
