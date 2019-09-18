//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment 3
public class Testish{

   private static int count=0;
   public static void main(String[] args){
      //if args length is 1, it is compared to elf
      if(args.length == 1){
         if(elfish(args[0]))
         System.out.println(args[0] + " " + "is elfish!");
         else
            System.out.println(args[0] + " " + "is not elfish!");
      }
      
      //if args length is two or more, the first two are compared
      else if(args.length >= 2){
         if(xish(args[0], args[1]))
            System.out.println(args[1] + " " + "is " + args[0] + "ish");
         else
            System.out.println(args[1] + " " + "is not " + args[0] + "ish");
      }
      
      //if there is no argument, then an error message is sent
      else{
         System.out.println("invalid argument, please insert one or two arguments");
      }
      
   }
   public static boolean elfish(String word){
      //word set to lowercase for comparison
      String x = "elf";
      word = word.toLowerCase();
      //if count is the length of elf, it is elfish, count is reset
      if(x.length()==count){
         count = 0;
         return true;
       }
      //if word contains the character at count, count is incremented and elfish is recursively called 
      if(word.indexOf(x.charAt(count))!=-1){
         count++;
         return elfish(word);
      }
      //if word does not contain the character at count, count is reset and false is returned
      count = 0;
      return false;    
    }
   public static boolean xish(String x, String word){
      //settings Strings to lowercase for comparison
      x = x.toLowerCase();
      word = word.toLowerCase();
      
      //if count is the length of x, it is xish, count is reset
      if(x.length()==count){
         count = 0;
         return true;
      }
      
      //if word contains the counth letter of x, count is added to and xish is recursively called
      if(newWord.indexOf(x.charAt(count))!=-1){
         count++;
         return xish(x, newWord);
      }
      //if word does not have the letter, it is not xish, count is reset
      count = 0;
      return false;
    }
    


}