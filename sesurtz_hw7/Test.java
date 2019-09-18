//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #7
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
public class Test{
   public static void main(String[] args){
      ProbeHashMap map = new ProbeHashMap();
      String keys;
      String values;
      int i = 0;
      try{
         Scanner input = new Scanner(new FileReader("roster.txt"));
         //each line adds the first word as a key, the rest of the line as a value, adds i
         while(input.hasNextLine()){
            keys =  input.next();
            values = input.nextLine();
            map.put(keys, values);
            i++;
         }
      }catch(FileNotFoundException ex){}
         Iterable iterable = map.keySet();//creates a keyiterable object from the probehasmap keySet method
         Iterator iterator = iterable.iterator(); //creates an iterator from the iterator method in the private class KeyIterable
         //runs maps tostring, prints index, key, value
         map.toString();
         //iterates over all keys
         while(iterator.hasNext()){
            System.out.println(iterator.next());
         }
         //prints collision
         System.out.println("Collisions " + map.getCollisions());

   }
}