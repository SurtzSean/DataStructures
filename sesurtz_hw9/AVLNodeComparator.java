//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #9
import java.util.Comparator;
public class AVLNodeComparator implements Comparator{
   public int compare(Object a, Object b){
      String aa = ((AVLTreeNode)a).getKey();
      String bb = ((AVLTreeNode)b).getKey();
      return aa.compareTo(bb);
   }
}