//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public class HeapPQueue extends AbstractPQueue {
  private ArrayList list = new ArrayList();

  public HeapPQueue(){
   super();
  }
  public HeapPQueue(EntryComparator comp){
   super(comp);
  }
  private int parent(int i){
   return(i-1)/2;
  }
  private boolean hasParent(int i){
   return parent(i)>=0;
  }
  private int left(int i){
   return 2*i + 2;
  }
  private int right(int i){
   return 2*i+2;
  }
  private boolean hasLeft(int i){
   return left(i) < list.size();
  }
  private boolean hasRight(int i){
   return right(i)<list.size();
  }
  private void swap(int i, int j){
   try{
      PQEntry temp = (PQEntry)list.get(i);
      list.set(i,list.get(j));
      list.set(j, temp);
   }catch(OutOfRangeException ex){
      System.out.println("Out of bounds");
   }
  }
  public int size(){
   return list.size();
  }
  private void heapUp(int j) throws OutOfRangeException{

   int k = parent(j);
   while(j>0){
     if(!hasParent(j)){
      break;
     }
      if(compare((PQEntry)list.get(j), (PQEntry)list.get(k))>=0)
         break;
      swap(j,k);
      list.set(k, list.get(j));
   }
  }
  private void heapdown(int j){
   try{while(j>size()-1){
      if(!hasLeft(j)) break;
      int leftIndex = left(j);
      int smallChildIndex = leftIndex;
      if(hasRight(j)){
         int rightIndex = right(j);
         if(compare((PQEntry)list.get(leftIndex), (PQEntry)list.get(rightIndex))>0)
            rightIndex = smallChildIndex;
      }
      if(compare((PQEntry)list.get(smallChildIndex),(PQEntry)list.get(j))>=0)
         break;
      swap(j,smallChildIndex);
      smallChildIndex = j;
      }
      }catch(OutOfRangeException ex){System.out.println("heapdown error");}
   }
  public PQEntry insert(Integer key, String value){
   PQEntry newPQ = new PQEntry(key, value);
   try{
      list.add(list.size(),newPQ);
      heapUp((int)key);
   }catch(OutOfRangeException ex){}
   return newPQ;
  }
  public PQEntry removeMin(){
   PQEntry answer = null;
   try{
   answer = (PQEntry)list.get(0);
   list.remove(0);
   list.set(0, (PQEntry)list.get(list.size()-1));
   list.remove(list.size()-1);
   heapdown(0);
   }catch(OutOfRangeException ex){System.out.println("Heap remove error");}
   return answer;
   
  }
  public PQEntry min(){
   try{
   return (PQEntry)list.get(0);
   }catch(OutOfRangeException ex){}
   return null;
  }
}
