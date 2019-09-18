//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
import java.util.Comparator;
public class EntryComparator{
   public int compare(Object a, Object b){
      int aKey = ((PQEntry)a).getKey();//gets key from PQ entries
      int bKey = ((PQEntry)b).getKey();
      return aKey-bKey; //if positive a>b, 0 a=b (not applicable here), if negative b>a
   }
}