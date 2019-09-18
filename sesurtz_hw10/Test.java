//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #10
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class Test{
   public static void main(String[] args){
      RBTreeMap map = new RBTreeMap();
      String keys, values;
      int i = 0;
      try{
         Scanner input = new Scanner(new FileReader("roster.txt"));
         while(input.hasNextLine()){//reads through lines, adds key/values
            keys =  input.next();
            values = input.nextLine();
            map.put(keys, values);
            i++;
         }
      }
      catch(FileNotFoundException ex){System.out.println("no file");}
      map.toString();
   }
}