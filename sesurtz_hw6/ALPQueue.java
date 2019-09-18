//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public class ALPQueue extends AbstractPQueue{
   private List list = new ArrayList();
   public ALPQueue(){
      super();
   }
   public ALPQueue(EntryComparator comp){
      super(comp);
   }
   public int size(){
      return list.size();
   }
   public PQEntry insert(Integer k, String v){
      PQEntry newest = new PQEntry(k,v);
      try{
         list.add(list.size(), newest);
      } catch(OutOfRangeException ex){
         System.out.println("Out of range alp");
      }
      return newest;
   }
   private int findMin(){
      int min = 0;
      if(list.size()==1) return min;
      try{
         for(int i = 1; i<list.size(); i++){
            if(compare((PQEntry)list.get(min),(PQEntry)list.get(i))>0){
               min = i;
            }
         }
      }catch(OutOfRangeException ex){
         System.out.println("Out of range alp");
       }
      return min;
   }
   public PQEntry min(){
      if(isEmpty())
         return null;
      PQEntry en = null;
      try{
         en = (PQEntry)list.get(findMin());
      }catch(OutOfRangeException ex){
         System.out.println("Out of range alp");
      }
      return en;
   }
   public PQEntry removeMin(){
      if(isEmpty()) 
         return null;
      PQEntry en = null;
      try{
         en = (PQEntry)list.remove(findMin());
      }catch(OutOfRangeException ex){
         System.out.println("Out of range alp");
      }
      return en;
   }
}