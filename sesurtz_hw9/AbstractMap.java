//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #9
public abstract class AbstractMap {
  public abstract Object get(Object key);
  public abstract Object put(Object key, Object value);
  public abstract Object remove(Object key);
  public abstract boolean isEmpty();
  public abstract int size();
  //public abstract Iterable keySet();
}