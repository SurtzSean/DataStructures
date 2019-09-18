//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #2
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileReader;
import java.util.Scanner;

public class HeartRate{
   
   public static void main(String[] args) throws IOException{
      Scanner input = new Scanner(new FileReader("HR.txt")); //reads HR file
      int goodData = 0; //ticks up for non-negative ints
      int badData = 0; //ticks up for non-ints & negative ints
      int myInt; //stores int to check for negative value
      
      while(input.hasNextLine()){
         try{         
            myInt = input.nextInt();
            
            if(myInt<0){ //throws exception if myInt is a negative value
               throw new HRIllegalValueException();
            }
            //adds to good data if no exception
            goodData++;
         }
         //non-integer values, adds to badData
         catch(InputMismatchException ex){
            badData++;
         }
         
         //catches negative number, puts it into bad data
         catch(HRIllegalValueException ex){
            badData++;
         }
         finally{
            if(input.hasNextLine())
               input.nextLine();
         }
      }
     System.out.println("Good data: " + goodData);
     System.out.println("Bad data: " + badData); 
    }
}