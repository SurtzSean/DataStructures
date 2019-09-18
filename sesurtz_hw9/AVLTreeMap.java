//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #9
public class AVLTreeMap extends AbstractMap {
  private int n;
  private AVLTreeNode root;
  private AVLTreeNode NIL = new AVLTreeNode();
  private AVLNodeComparator comp = new AVLNodeComparator();

  public AVLTreeMap() {
    super();
    n = 0;
    root = null;
  }
  public int size() {return n;} //returns number of objects
  public boolean isEmpty() {return n == 0;} //returns true if no objects

  public Object get(Object key) { //gets object with specific key
    String k = (String)key;
    int c = k.compareTo((String)root.getKey());
    if(c==0){
      return root.getValue();
    }
    else if(c<0){
      return r_get(root.getLeft(),k);
    }
    else{
      return r_get(root.getLeft(), k);
    }
  }

  public Object put(Object key, Object value) {
    AVLTreeNode newNode = new AVLTreeNode((String)key, (String)value);
    newNode.setLeft(NIL);
    newNode.setRight(NIL);
    if(root == null){
      root = newNode;
      n++;
    }
    else
      insertAVL(root, newNode);
    return newNode;
  }

  private void insertAVL(AVLTreeNode p, AVLTreeNode node) {
    if(comp.compare(node, p) == 0){
      p.setValue(node.getValue());
      return;
    }
    else if(comp.compare(p, node) > 0){
      if(p.getLeft() == NIL){
         p.setLeft(node);
         node.setParent(p);
         p.setHeight();
         n++;
      }
      else{
         insertAVL(p.getLeft(), node);
         if(p.calBF() < -1){
           AVLTreeNode j = p.getLeft();
            if(j.calBF() < 0) //LL
               rotateLL(p);
            else //LR
               rotateLR(p);
         }
      p.setHeight();
      }

    }
    else{
        //node key > p.key
        if(p.getRight() == NIL){
            p.setRight(node);
            node.setParent(p);
            p.setHeight();
            n++;
        }
        else{
         insertAVL(p.getRight(), node);
         if(p.calBF()>1){
            AVLTreeNode j = p.getRight();
         
            if(j.calBF()>0)//RR
               rotateRR(p);
            else
               rotateRL(p);
            
         }
         p.setHeight();
        }
     }
  }

  private AVLTreeNode rotateLL(AVLTreeNode p) {
      AVLTreeNode pp = p.getParent();
      AVLTreeNode j = p.getLeft();
      AVLTreeNode ball = j.getRight();
      j.setParent(pp);
      if(pp == null)
         root = j;
      else if (p == pp.getLeft())
         pp.setLeft(j);
      else
         pp.setRight(j);
      j.setRight(p);
      p.setLeft(ball);
      ball.setParent(j);
      p.setHeight();
      j.setHeight();
      return j;
      
  }

  private AVLTreeNode rotateLR(AVLTreeNode p) {
    AVLTreeNode j = p.getLeft();
    AVLTreeNode i = j.getRight();
    AVLTreeNode v = i.getLeft();
    p.setLeft(i);
    i.setParent(p);
    i.setLeft(j);
    j.setParent(i);
    j.setRight(v);
    v.setParent(j);
    j.setHeight();
    i.setHeight();
    return rotateLL(p);
  }

  private AVLTreeNode rotateRR(AVLTreeNode p) {
    AVLTreeNode j = p.getRight();
    AVLTreeNode pp = p.getParent();
    AVLTreeNode i = j.getLeft();
    if(pp == null){
      root = j;

    }
    else if (p == pp.getLeft()){
      pp.setLeft(j);
    }
    else{
      pp.setRight(j);  
    }
    j.setParent(pp);
    j.setLeft(p);
    p.setParent(j);
    p.setRight(i);
    i.setParent(p);
    p.setHeight();
    return j;
  }

  private AVLTreeNode rotateRL(AVLTreeNode p) {
    AVLTreeNode j = p.getRight();
    AVLTreeNode i = j.getLeft();
    AVLTreeNode v = i.getRight();
    p.setRight(i);
    i.setParent(p);
    i.setRight(j);
    j.setParent(i);
    j.setLeft(v);
    v.setParent(j);
    j.setHeight();
    i.setHeight();
    return rotateRR(p);
  }

  public Object remove(Object key) {
    return null;
    // remove is not required for this assignment
  }

  public String toString() {
      String nTotal = ("n=" + n);
      System.out.print(nTotal+"\n");
      printPreOrder(root);
      return"";
  }
  
  private String r_get(AVLTreeNode r, String k){
   if(r == NIL)
      return null;
   int c = k.compareTo((String)r.getKey());
   if(c==0) //base
      return r.getValue();
   else if(c<0)
      return r_get(r.getLeft(),k);
   else
      return r_get(r.getRight(), k);
   
  }
  
  /*private int calHeight(AVLTreeNode p){
   if(p.getRight().getHeight()<p.getLeft().getHeight())//l>r
      return p.getLeft().getHeight()+1;
   else//r<l
      return p.getRight().getHeight()+1;
  }*/
  
  private void printPreOrder(AVLTreeNode check){//recursive preorder
   System.out.print(check.getKey() + "--");
   if(check.getLeft()!=NIL) printPreOrder(check.getLeft());
   if(check.getRight() !=NIL) printPreOrder(check.getRight()); 
  }
}