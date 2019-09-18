//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public interface List{
   public int size();
   public boolean isEmpty();
   public Object get(int i) throws OutOfRangeException;
   public void add(int i, Object e) throws OutOfRangeException;
   public void set(int i, Object e) throws OutOfRangeException;
   public Object remove(int i) throws OutOfRangeException;
}