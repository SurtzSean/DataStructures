//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #4
public class ArrayStack implements IStack{
   private Object[] data; //array of generic objects
   private int size; //number of objects in stack
   private static int CAP; //max number of objects in stack
   
   //constructor takes an int, initialises size to 0 and CAP to capacity, makes an array of length capacity
   public ArrayStack(int capacity){
      this.CAP = capacity;
      this.size = 0;
      this.data = new Object[capacity];
   }
   
   //default capacity set to 32
   public ArrayStack(){
      this(32);
   }
   
   //returns number of elements in the stack
   public int size(){
      return size;
   }
   
   //returns true if stack has no elements
   public boolean isEmpty(){
      return size() == 0;
   }
   
   //pushes an item onto the stack, throws StackFullException if stack is full
   public void push(Object item) throws StackFullException{
      if(size==CAP)
         throw new StackFullException(" out of space");
      //increments size and places item in the stack
      data[size] = item;
      size++;
   }
   
   //returns the last object and removes it from the stack
   public Object pop(){
      Object answer = data[size-1];
      //if answer is null, it doesnt decrement; it just return null.
      if(answer==null){
         return null;
      }
      //sets object at size-1's spot to null and decrements size
      data[size-1] = null;
      size--;
      return answer;
   }
   
   //returns top object
   public Object top(){
      return data[size-1];
   }
}
