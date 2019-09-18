//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #8
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
public class Test{
   public static void main(String[] args){
      ProbeHashMap map = new ProbeHashMap(109, 999331);
      DblHashMap dblMap = new DblHashMap(109,999331);
      
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
            dblMap.put(keys,values);
            i++;
         }
      }catch(FileNotFoundException ex){}
         Iterable iterable = map.keySet();//creates a keyiterable object from the probehasmap keySet method
         Iterable dblIterable = dblMap.keySet();
         Iterator iterator = iterable.iterator(); //creates an iterator from the iterator method in the private class KeyIterable
         Iterator dblIterator = dblIterable.iterator();
         //runs maps tostring, prints index, key, value
         System.out.println("linear to string");
         map.toString();
         System.out.println("doublehash to string");
         dblMap.toString();
         //iterates over all keys
         System.out.println("Linear iterator");
         while(iterator.hasNext()){
            System.out.println(iterator.next());
         }
         System.out.println("doublehash iterator");
         while(dblIterator.hasNext()){
            System.out.println(dblIterator.next());
         }
         //prints collision
         System.out.println("Linear Collisions " + map.getCollisions());
         System.out.println("Dbl Collisions " + dblMap.getCollisions());

   }
}