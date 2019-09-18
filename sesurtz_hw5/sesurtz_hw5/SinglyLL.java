//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #5
public class SinglyLL{

   private class LLNode{
      private Object element;
      private LLNode next;
      //gives node an element and sets next element
      public LLNode(Object e, LLNode n){
         element = e;
         next = n;
      }
      //returns element in node
      public Object getElement(){
         return element;
      }
      //set new element in node
      public void setElement(Object e){
         element = e;
      }
      //returns element in node
      public LLNode getNext(){
         return next;
      }
      //set the next element in the ll
      public void setNext(LLNode n){
         next = n;
      }
   }
   
   private int size;
   private LLNode head;
   private LLNode tail;
   public SinglyLL(){};
   
   //returns elements in the ll
   public int size(){
      return size;
   }
   
   //checks if ll is empty
   public boolean isEmpty(){
      return size == 0;
   }
   
   //returns element in head
   public Object first(){
      if(isEmpty())
         return null;
      return head.getElement();
   }
   
   //returns element in tail
   public Object Last(){
      if(isEmpty())
         return null;
      return tail.getElement();
   }
   
   //adds new head
   public void addFirst(Object e){
      head = new LLNode(e,head);
      if(size==0)
         tail = head;
      size++;
   }
   
   //adds new tail connects old tail to new tail
   public void addLast(Object e){
      LLNode newTail = new LLNode(e, null);
      if(size == 0) 
         head = newTail;
      else
         tail.setNext(newTail);
      tail = newTail;
      size++;
   }
   
   //removes head, sets new head, returns head
   public Object removeFirst(){
      if(isEmpty()) 
         return null;
      Object answer = head.getElement();
      head = head.getNext();
      size--;
      if(size==0)
         tail = null;
      return answer;
   }
   
}