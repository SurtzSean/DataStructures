//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public class Test{
   public static void main(String[] args){
      Integer[] keys = new Integer[5000];
      for (int i = 0; i<5000; i++){
         keys[i] = (int)Math.random()*100000;
      }
      String[] values = new String[keys.length];
      for(int i = 0; i<keys.length; i++){
         values[i] = "CIS " + keys[i];
      }
      ALPQueue alpQueue = new ALPQueue();
      HeapPQueue heap = new HeapPQueue();
      ALPQueue test = new ALPQueue();
      
      long start;
      long end;
      
      start = System.currentTimeMillis();
      for(int i = 0; i<keys.length; i++){
         heap.insert(keys[i], values[i]);
      }
      end = System.currentTimeMillis();
      long heapInsert = end-start;
      
      start = System.currentTimeMillis();
      for(int i = 0; i<keys.length; i++){
         alpQueue.insert(keys[i], values[i]);
      }
      end = System.currentTimeMillis();
      long alpInsert = end-start;
      
      start = System.currentTimeMillis();
      while(!alpQueue.isEmpty()){
         alpQueue.removeMin();
      }
      end = System.currentTimeMillis();
      long alpRemove = end-start;
      
      start = System.currentTimeMillis();
      while(!heap.isEmpty()){
         heap.removeMin();
      }
      end = System.currentTimeMillis();
      long heapRemove = end-start;
      
      System.out.println("ALPQueue"); 
      System.out.println("Insert 5000 entries: " + alpInsert);
      System.out.println("Remove 5000 entries: " + alpRemove);
      
      System.out.println("Heap"); 
      System.out.println("Insert 5000 entries: " + heapInsert);
      System.out.println("Remove 5000 entries: " + heapRemove );
      
      
   }
}