//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #10
import java.util.Comparator;

public class RBTreeMap extends AbstractMap {
  private int n;
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private RBNode root;
  private RBNode NIL = new RBNode();
  private RBNodeComparator comp = new RBNodeComparator();
  RBTreeMap() {
    super();
    n=0;
    root = null;
  }
  public int size() {return n;}
  public boolean isEmpty() {return n == 0;}

  public Object get(Object key) {
    return null;
  }

  public Object put(Object key, Object value) {
    RBNode newNode = new RBNode((String)key,(String)value);
    newNode.setRight(NIL);
    newNode.setLeft(NIL);
    if(root == null){
      root = newNode;
      root.setColor(BLACK);
      n++;
    }
    else{
      insert_RB(root, newNode);
      n++;
    }
    return newNode;
  }
  private void case1(RBNode z){ //case1
   RBNode p =  z.getParent();
   RBNode pp = p.getParent();
   RBNode d;
   if(p == pp.getLeft())
      d = pp.getRight();
   else
      d = pp.getLeft();
   p.setColor(BLACK);
   d.setColor(BLACK);
   pp.setColor(RED);
   insert_fixup(root, pp);
  }
 
  
  private void case3(RBNode z){
     RBNode p = z.getParent();
     RBNode pp = p.getParent();
      right_rotate(pp);
   p.setColor(BLACK);
   pp.setColor(RED);
  }
  private void case3Prime(RBNode z){
     RBNode p = z.getParent();
     RBNode pp = p.getParent();
      left_rotate(pp);
   p.setColor(BLACK);
   pp.setColor(RED); 
  }


  private void insert_fixup(RBNode r, RBNode z) {
    RBNode p = z.getParent();
    if(p == null || p == root || p.getColor()==BLACK)
      return;
    RBNode pp = p.getParent();
    if(p == pp.getLeft()){
      RBNode d = pp.getRight();
      if(p.getColor() == RED && d.getColor()==RED)
         case1(z);
      else{if(z == p.getRight()){
            left_rotate(p);
      z = z.getLeft();}
         case3(z);
      }
      }
    else if(p == pp.getRight()){
      RBNode d = pp.getLeft();
      if(d!=NIL&&p.getColor() == RED && d.getColor()==RED)
         case1(z);
      else{
      if(z == p.getLeft()){right_rotate(p);
   z = z.getRight();}
         case3Prime(z);
      }
  }
    root.setColor(BLACK);
}
  
  private void insert_RB(RBNode p, RBNode z){
   if(comp.compare(p,z)<0){//p<z
      if(p.getRight()!=NIL&&p.getRight()!=null)
         insert_RB(p.getRight(), z);
      else{
         p.setRight(z);
         z.setParent(p);
         insert_fixup(root, z);
      }
   }
   else if(comp.compare(p,z)==0){
      return;
   }

   else if(comp.compare(p,z)>0){//p>z
      if(p.getLeft()!=NIL&&p.getRight()!=null)
         insert_RB(p.getLeft(), z);
      else{
         p.setLeft(z);
         z.setParent(p);
         insert_fixup(root, z);
      }
   }
  }

  private RBNode left_rotate(RBNode x) {
  RBNode p = x.getParent();
   RBNode y = x.getRight();
   RBNode v = y.getLeft();
   x.setRight(v);
   if(v!=NIL)
      v.setParent(x);
   y.setParent(p);
   if(p==null)
      root = y;
   else if(x == p.getLeft())
      p.setLeft(y);
   else{
      p.setRight(y);
   }
   y.setLeft(x);
   x.setParent(y);
   return y;
  }

  private RBNode right_rotate(RBNode y) {
   RBNode p = y.getParent();
   RBNode x = y.getLeft();
   RBNode v = x.getRight();
   y.setLeft(v);
   if(v!=NIL)
      v.setParent(y);
   x.setParent(p);
   if(p==null)
      root = x;
   else if(y == p.getRight())
      p.setRight(x);
   else
      p.setLeft(x);
   x.setRight(y);
   y.setParent(x);
   return x;
  }

  public Object remove(Object key) {
    return null;
  }

  private class RBNode extends MapEntry {
    private boolean color;
    private RBNode left;
    private RBNode right;
    private RBNode parent;
    RBNode() {// NIL Node
      super(null, null);
      color = BLACK;
      parent = null;
      left = null;
      right = null;
    }
    RBNode(String key, String value) {
      super(key, value);
      color = RED;
    }
    protected RBNode getLeft() {return left;}
    protected RBNode getRight() {return right;}
    protected RBNode getParent() {return parent;}
    protected void setLeft(RBNode l) {left = l;}
    protected void setRight(RBNode r) {right = r;}
    protected void setParent(RBNode p) {parent = p;}
    protected boolean getColor() {return color;}
    protected void setColor(boolean c) {color = c;}
  }

  private class RBNodeComparator implements Comparator {
    public int compare(Object a, Object b) {
      String aa = ((RBNode)a).getKey();
      String bb = ((RBNode)b).getKey();
      if (a == null && b == null) return 0;
      else if (a == null) return -1;
      else if (b == null) return 1;
      else {
        int size = Math.min(aa.length(), bb.length());
        for (int i = 0; i<size; i++) {
          if (aa.charAt(i) > bb.charAt(i))
            return 1;
          else if (aa.charAt(i) < bb.charAt(i))
            return -1;
        }
        // first size characters are equal to each other
        if (size == aa.length()) return -1;
        return 1;
      }
    }
  }
  public String toString(){
   printPreOrder(root);
   return "";
  }
  
  private void printPreOrder(RBNode check){//recursive preorder
   System.out.print(check.getKey() + "--");
   if(check.getLeft()!=NIL) printPreOrder(check.getLeft());
   if(check.getRight() !=NIL) printPreOrder(check.getRight()); 
  }
}