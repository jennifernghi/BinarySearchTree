

public abstract class AbstractTree<E> implements Tree<E> {
  @Override /** Inorder traversal from the root*/
  public void inorder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
  }

  @Override /**Breadth-first traversal from the root */
  public void breadthFirstTraversal(){
  }
  
  @Override /** Inorder traversal from the root non-recursive and using stack */
  public void nonRecursiveInorder(){	  
  }
  
  @Override /** Preorder traversal from the root non-recursive and using stack */
  public void nonRecursivePreorder(){	  
  }
  
  @Override/** Postorder traversal from the root non-recursive and using stack */
  public void nonRecursivePostorder(){
  }
  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
 
}
