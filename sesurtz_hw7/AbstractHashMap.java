//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #7
import java.util.Random;
public abstract class AbstractHashMap extends AbstractMap{
   protected int n = 0;
   protected int capacity;
   private int prime;
   private long scale, offset;
   public AbstractHashMap(int c, int p){
      this.capacity = c;
      this.prime = p;
      Random rand = new Random();
      this.scale = rand.nextInt(prime-1) + 1;
      this.offset = rand.nextInt(prime);
      createTable();
   }
   public AbstractHashMap(){
      this(61, 999331);
   }
   public int size(){
      return n;
   }
   public boolean isEmpty(){
      return n == 0;
   }
   private int hashValue(Object key){
      return (int)((Math.abs(key.hashCode()*scale+offset)%prime)%capacity);
   }
   public Object get(Object key){
      int h = hashValue(key);
      return bucketGet(h, key);
   }
   public Object put(Object key, Object value){
      int h = hashValue(key);
      return bucketPut(h, key, value);
   }
   public Object remove(Object key){
      int h = hashValue(key);
      return bucketRemove(h, key);
   }
   protected abstract void createTable();
      protected abstract Object bucketGet(int h, Object k);
      protected abstract Object bucketPut(int h, Object k, Object v);
      protected abstract Object bucketRemove(int h, Object k);
   
}