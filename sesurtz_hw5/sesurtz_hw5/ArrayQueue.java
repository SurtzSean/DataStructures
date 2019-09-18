//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #5
public class ArrayQueue implements IQueue{
   private Object[] data;
   private static int CAP;
   private int head;
   private int tail;
   
   public ArrayQueue(int capacity){
      data = new Object[capacity];
      CAP = capacity;
      head = 0;
      tail = 0;
   }
   
   public ArrayQueue(){
      this(16);
   }
   //returns number of elements in queue
   public int size(){
      if(head>tail)
         return CAP-head+tail;
      else if(tail>head)
         return tail-head;
      else
         return 0;
   }
   //returns if queue is empty
   public boolean isEmpty(){
      return head==tail;
   }
   //adds object into queue
   public void add(Object item) throws QueueFullException{
      if(size() == CAP-1){
         throw new QueueFullException();
      }
      data[tail] = item;
      tail = ++tail%CAP;
   }
   //removes head, sets new head
   public Object remove(){
      if(isEmpty())
         return null;
      Object answer = data[head];
      head = ++head%CAP;
      return answer;
   }
   //returns head
   public Object first(){
      if(isEmpty())
         return null;
      return data[head];
   }
}