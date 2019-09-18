//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public class OutOfRangeException extends Exception{
   public OutOfRangeException(){
      System.out.println("Out of range");
   }
   public OutOfRangeException(String msg){
      System.out.println(msg);
   }
}