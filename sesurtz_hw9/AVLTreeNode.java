//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #9
public class AVLTreeNode extends MapEntry{
   private AVLTreeNode parent;
   private AVLTreeNode left;
   private AVLTreeNode right;
   private int height;
   public AVLTreeNode(){ //NIL Node
      super();
      parent = null;
      left = null;
      right = null;
      height = -1;
   }
   //node with key and value
   public AVLTreeNode(String key, String value){
      super(key,value);
      parent = null;
      left = null;
      right = null;
      height = 0;
   }
   
   //setters and getters
   public AVLTreeNode getLeft(){//returns left node
      return left;
   }
   public AVLTreeNode getRight(){//returns right node
      return right;
   }
   public AVLTreeNode getParent(){//returns parent node
      return parent;
   }
   public void setLeft(AVLTreeNode l){// set left node
      left = l;
   }
   public void setRight(AVLTreeNode r) {//set right node
      right = r;
   }
   public void setParent(AVLTreeNode p){//set parent node
      parent = p;
   }
   public int getHeight(){//returns height
      return height;
   }
   public void setHeight(){//sets height
      //height = h;
      height = Math.max(left.getHeight(), right.getHeight())+1;
   }
   
   
   public int calBF(){//calculates balance factor
      return right.getHeight() - left.getHeight();
   }
   
   
}