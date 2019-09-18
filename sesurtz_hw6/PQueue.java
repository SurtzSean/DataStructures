//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public interface PQueue{
   public PQEntry insert(Integer k, String v);
   public PQEntry removeMin();
   public PQEntry min();
   public int size();
   public boolean isEmpty();
}