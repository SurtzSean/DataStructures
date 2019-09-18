//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #5
public class LLQueue implements IQueue {
  private SinglyLL data;
  
  //creates a singly linked list
  public LLQueue() {
    data = new SinglyLL();
  }
   //returns elements in list
  public int size() {  
    return data.size();
  }
  //returns if the list has 0 elements
  public boolean isEmpty() { 
    return data.isEmpty();
  }
   //adds object into list
  public void add(Object item){
    data.addLast(item);
  }
  //returns first element in queue
  public Object first() {
    return data.first();
  }
  //removes element in queue
  public Object remove() {
    Object answer = data.removeFirst();
    return answer;
  }
}