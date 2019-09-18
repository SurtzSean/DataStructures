//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #5
public class Test{
   public static void main(String[] args) throws QueueFullException{
      ArrayQueue testQueue = new ArrayQueue(10000);
      long beforeAQ = System.currentTimeMillis();
      //testing ArrayQueue's time
      for(int i = 0; i<5000; i++){
         testQueue.add(Math.random()*10000);
         testQueue.remove();
         testQueue.add(Math.random()*10000);
      }
      long afterAQ = System.currentTimeMillis();
      long arrayResult = afterAQ-beforeAQ;
      System.out.println("Array Queue time: " + arrayResult + " milliseconds");

      long beforeLLQueue = System.currentTimeMillis();
      LLQueue testLLQueue = new LLQueue();
      //testing linked list queue time
      for(int i = 0; i< 5000; i++){
         testLLQueue.add(Math.random()*10000);
         testLLQueue.remove();
         testLLQueue.add(Math.random()*10000);
      }
      long afterLLQueue = System.currentTimeMillis();
      long llResult = afterLLQueue-beforeLLQueue;
      System.out.println("Linked List Queue time: " + llResult + " milliseconds");
   }
}   
