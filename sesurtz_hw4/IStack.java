//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #4
public interface IStack{
   public abstract void push(Object item) throws StackFullException;
   public abstract int size();
   public abstract boolean isEmpty();
   public abstract Object pop();
   public abstract Object top();
}