public interface IQueue{
   int size();
   boolean isEmpty();
   void add(Object item) throws QueueFullException;
   Object remove();
   Object first();
}
