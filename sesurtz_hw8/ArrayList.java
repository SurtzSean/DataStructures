//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #7
public class ArrayList implements List{
   private int CAP;
   private int size;
   private Object[] item;
   
   public ArrayList(int capacity){
      this.CAP = capacity;
      this.size = 0;
      this.item = new Object[capacity];
   }
   public ArrayList(){
      this(5000);
   }
   public int size(){
      return size;
   }
   public boolean isEmpty(){
      return size==0;
   }
   public Object get(int i) throws OutOfRangeException{
      if(i<0||i>=size){
         throw new OutOfRangeException();
      }
      return item[i];
   }
   public void set(int i, Object e) throws OutOfRangeException{
      if(i<0||i>=size){
         throw new OutOfRangeException();
      }
      item[i] = e;
   }
   public void add(int i, Object e) throws OutOfRangeException{
      if(i<0||i>size){
         throw new OutOfRangeException();
      }
      for(int j = size-1; j>=i; j--){
         item[j+1] = item[j];
      }
      item[i] = e;
      size++;
   }
   public Object remove(int i) throws OutOfRangeException{
      if(i<0||i>=size){
         throw new OutOfRangeException();
      }
      Object answer = item[i];
      for(int j = i; j<size-1; j++){
         item[j] = item[j+1];
      }
      item[size-1] = null;
      size--;
      return answer;
   }
   
}