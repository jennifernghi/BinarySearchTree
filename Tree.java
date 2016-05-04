import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
  /** Return true if the element is in the tree */
  public boolean search(E e);

  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully */
  public boolean insert(E e);

  /** Delete the specified element from the tree
   * Return true if the element is deleted successfully */
  public boolean delete(E e);

  /** Inorder traversal from the root*/
  public void inorder();

  /** Postorder traversal from the root */
  public void postorder();

  /** Preorder traversal from the root */
  public void preorder();
  
  /**Breadth-first traversal from the root */
  public void breadthFirstTraversal();

  /** Get the number of nodes in the tree */
  public int getSize();

  /** Return true if the tree is empty */
  public boolean isEmpty();
  
  /** return the height of the tree */
  public int height();
  
  /** Returns true if the tree is a full binary tree */
  public boolean isFullBST();
  
  /** Inorder traversal from the root non-recursive and using stack */
  public void nonRecursiveInorder();
  
  /** Preorder traversal from the root non-recursive and using stack */
  public void nonRecursivePreorder();
  
  /** Postorder traversal from the root non-recursive and using stack */
  public void nonRecursivePostorder();
  
  /** Returns the number of leaf nodes */
  public int getNumberOfLeaves();
  
  /** Returns the number of nonleaf nodes */
  public int getNumberofNonLeaves();

  /** Returns an iterator for traversing the elements in preorder */
  public Iterator<E> preorderIterator();
}

