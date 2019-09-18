//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #8
import java.util.Iterator;
public class DblHashMap extends AbstractHashMap{
 private MapEntry[] table;
  private MapEntry DEFUNCT = new MapEntry(null,null);
  private int nCollisions = 0;

  //default constructor, just calls super constructor; defaults capacity 61, prime 999331
  public DblHashMap(){super();}
  //2 args constructor, cap and p.  p must be a prime number
  public DblHashMap(int cap, int p){super(cap, p);}

   //compares String s to String t; adds nCollisions
  private boolean compareStr(String s, String t) {
    if (s.equals(t)) 
      return true;
    nCollisions++; //every false comparison +1 to nCollisions, this is a way to measure each run's efficiency
    return false;
  }

   //creates a table of a given or default capactiy
  protected void createTable() {
    table = new MapEntry[capacity];
  }
   //finds if slot has anything in it currently
  private boolean isAvailable(int i) {
    return table[i]==null||table[i]==DEFUNCT;
  }

 private int findSlot(int h, String k) {
    int avail = -1;
    int i = h;
    int q = 7;
    int count = 0;
    do{
      if(isAvailable(i)){
         if(avail==-1) 
            avail=i;
         if(table[i] == null)
            break;
      }
      else if(compareStr(table[i].getKey(),k)){
         return i;
      }
     i=doubleHash(count, h, q);
     count++;
    }while(i!=h);
    return-(avail+1);
  }

  private int doubleHash(int count, int h, int q){
   return ((h+1)%capacity + count*(q-(h)%q))%capacity;
  }
   //called by put in abstract method; adds object
  protected Object bucketPut(int h, Object key, Object value) {
    int i = findSlot(h,(String)key);
    if(i>=0)
      return table[i];
    else if(i<0)
      table[-(i+1)] = new MapEntry((String)key, (String)value);
    n++; //object added, size incremented
    return value;
  }

   //called by get in abstract method; gets object
  protected Object bucketGet(int h, Object key) {
    int i = findSlot(h,(String)key);
    if(i<0)
      return null;
    return table[i].getValue();
  }
   //called by remove in abstract method; removes object
  protected Object bucketRemove(int h, Object key) {
    int i = findSlot(h,(String)key);
    if(i<0)
      return null;
    Object answer = table[i].getValue();
    table[i] = DEFUNCT; //sets table[i]'s value to a null mapent
    n--; //object removed, size decremented
    return answer;
  }
   //creates sarrayiterator of your map so you can iterate through keys
  private class KeyIterable implements Iterable {
    public Iterator iterator() {
      ArrayList buffer = new ArrayList(n);
      for (int i=0; i<capacity; i++)
        try {
          if (!isAvailable(i)) 
            buffer.add(buffer.size(), table[i].getKey());
        } catch (OutOfRangeException e) {System.out.println("keySet: Out Of Range");} 

      return new SArrayIterator(buffer);
    }
  }
   //to create sarrayiterator object
  public Iterable keySet() {
    return new KeyIterable();
  }

  public int getCollisions() {return nCollisions;}
  //prints out index, key, value in map
  public String toString() {
    for(int i = 0; i<capacity; i++){
      if(table[i]!=null)
      System.out.println(i + " " + table[i].getKey() + " " + table[i].getValue());
    }
    return"";
  }


}