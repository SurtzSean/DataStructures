//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #4
import java.util.Scanner;

public class Evaluate{

  public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter an expression: ");
      String exp = scan.nextLine();
      System.out.println(expression(exp));
  }
  
  private static final String operators = "d*+-()";
  private static final String open = "(";
  private static final String close = ")";
  private static final String parens= "()";
  
  
  public static int expression(String str) {
   IStack vals = new ArrayStack(str.length());
   IStack ops = new ArrayStack(str.length());
   String num;
   int val1;
   int val2;
   char operation;
   try{
   ops.push('d');
   //read through each character of str
   for(int i = 0; i<str.length(); i++){
      if(str.charAt(i)==' '){
         continue;
      }
      num = "";
      //if number, push onto val stack
      while(i<str.length() && operators.indexOf(str.charAt(i))==-1){
         num+=str.charAt(i);
         i++;
      }
      //push number to vals stack
      if(!num.isEmpty())
         vals.push(Integer.parseInt(num));
          
      //perform operations if the operation at position is equal to or less than top of operator stack
      while(i<str.length()&&vals.size()>1 && prioritizer(str.charAt(i))<=prioritizer((char)ops.top())){
         val1 = (int)vals.pop();
         val2 = (int)vals.pop();
         operation = (char)ops.pop();
         vals.push(doOp(val1, val2, operation));
      }
      
      //push next operation to operation stack
      if(i<str.length())
         ops.push(str.charAt(i));
   }
   //perform remaining operations
   while(vals.size()>1){
      val1 = (int)vals.pop();
      val2 = (int)vals.pop();
      operation = (char)ops.pop();
      vals.push(doOp(val1, val2, operation));
   }   
   return (int)vals.top();
  }
  catch(StackFullException e){
   System.out.println("Error");
  }
  return 0;
  }
  
  //prioritizes based on order of operations
  private static int prioritizer(char c){
   if(c == '+' || c == '-')
      return 1;
   else if(c == '*')
      return 2;
   else if(c == 'd')
      return -1;
   else if(c == '(')
      return 3;
   else if(c == ')')
      return 3;
   return -99;  
   }
   
   //performs operation +,-,*
   private static int doOp(int val1, int val2, char c){
   
   switch(c){
      case('+'):
         return val1 + val2;
      case('-'):
         return val2 - val1;
      case('*'):
         return val1 * val2;
      default:
         return -1;
   }
  } 
}