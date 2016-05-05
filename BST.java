import java.util.*;

public class BST<E extends Comparable<E>> 
    extends AbstractTree<E> {
  protected TreeNode<E> root;
  protected int size = 0;

  /** Create a default binary tree */
  public BST() {
  }

  /** Create a binary tree from an array of objects */
  public BST(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

 
  @Override /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }

    return false;
  }

  @Override /** Insert element o into the binary tree
   * Return true if the element is inserted successfully */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted

      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }

    size++;
    return true; // Element inserted successfully
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  @Override /** Inorder traversal from the root */
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  @Override/**Breadth-first traversal from the root */
  public void breadthFirstTraversal()
  {
	  breadthFirstTraversal(root); //breadthFirstTraversal from the root
	 
  }
  
  protected void breadthFirstTraversal(TreeNode<E> node)
  {
	  /*
	   * store the binary as a queue since we want to access from the beginning of the list
	   */
	  Queue<TreeNode<E>> queue = new LinkedList<>();// use LinkedList to create a queue
	  if (node == null) return;//exit method
	        
	    queue.add(node);//add the root
	    while(!queue.isEmpty()){
	    	//remove and retrieve the head of the queue and assign that to current, now current is the node just removed
	        TreeNode<E> current = queue.remove();
	        System.out.print(current.element + " ");// print out the element
	        if(current.left != null) //if the node has left children
	        {	
	        	queue.add(current.left);// add it's left children to the queue
	        }
	        if(current.right != null)//if the node has right children
	        {
	        	queue.add(current.right);// add it's right children
	        }
	    }
	  
  }
  /** This inner class is static, because it does not access 
      any instance members defined in its outer class */
  public static class TreeNode<E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public boolean visited;

    public TreeNode(E e) {
      element = e;
      left = null;
      right = null;
      visited = false;
    }
  }

  @Override /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode<E> getRoot() {
    return root;
  }

  /** Returns a path from the root leading to the specified element */
  public java.util.ArrayList<TreeNode<E>> path(E e) {
    java.util.ArrayList<TreeNode<E>> list =  new java.util.ArrayList<>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else
        break;
    }

    return list; // Return an array list of nodes
  }

  @Override /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed at by current
    }

    if (current == null)
      return false; // Element is not in the tree

    // Case 1: current has no left child
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;

      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;     
    }

    size--;
    return true; // Element deleted successfully
  }

  @Override /** Obtain an iterator. Use inorder. */
  public Iterator<E> iterator() 
  {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  private class InorderIterator implements Iterator<E> {
    // Store the elements in a list
    private ArrayList<E> list = new ArrayList<>();
    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root*/
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    @Override /** More elements for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;

      return false;
    }

    @Override /** Get the current element and move to the next */
    public E next() {
      return list.get(current++);
    }

    @Override /** Remove the current element */
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  @Override/** Returns an iterator for traversing the elements in preorder */
  public Iterator<E> preorderIterator()
  {
	  return new preorderIterator();
  }
  
  private class preorderIterator implements Iterator<E>
  {
	  private ArrayList<E> list = new ArrayList<>();
	  private int current =0;
	  
	  public preorderIterator()
	  {
		  preorder();
	  }
	  
	  private void preorder()
	  {
		  preorder(root);
	  }
	  
	  private void preorder(TreeNode<E> node)
	  {
		  if (node == null) return;
		  list.add(node.element);
		  preorder(node.left);
		  preorder(node.right);
	  }
	  
	  @Override /** More elements for traversing? */
	    public boolean hasNext() {
	      if (current < list.size())
	        return true;

	      return false;
	    }

	  @Override /** Get the current element and move to the next */
	    public E next() {
	      return list.get(current++);
	    }

	    @Override /** Remove the current element */
	    public void remove() {
	      delete(list.get(current)); // Delete the current element
	      list.clear(); // Clear the list
	      preorder(); // Rebuild the list
	    }
  }
  /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }
  
  @Override/** return the height of the tree */
  public int height()
  {  
	return getHeight(root);
  }
  
  protected int getHeight(TreeNode<E> node)
  {
	  if(node==null)
	  {
		  return -1;// if no node height is -1
	  }else
	  {
		  int leftHeight = getHeight(node.left);
		  int rightHeight = getHeight(node.right);
		  return 1+ Math.max(leftHeight, rightHeight);
	  }
	  
  }
  
  @Override/** Inorder traversal from the root non-recursive and using stack */
  public void nonRecursiveInorder()
  {
	  nonRecursiveInorder(root);
	  
  }
  protected void nonRecursiveInorder(TreeNode<E> node)
  {
	  /*
	   * STEP 1: create a stack
	   * STEP 2: assign node (root) as current  
	   * STEP 3: start from the root (current)
	   * 	    push the current node to the stack
	   *        then assign it's left child as new current
	   *        Keep repeating until current node has no child
	   * STEP 4: pop the last element of the stack and assign it as new current
	   * 		print out current node
	   *        the assign it's right child as new current
	   *        then, repeat step 3
	   *        if the stack now is empty, exit 
	   */
	  Stack<TreeNode<E>> stack = new Stack<>();//STEP 1
	  TreeNode<E> current = node;//STEP 2
	  while(true)
	  { 
		 if(current!=null)//STEP 3
		 {
			 stack.push(current);
			 current=current.left;
		 }else if(!stack.isEmpty())//STEP 4
		 {
			 current=stack.pop();
			 System.out.print(current.element+ " ");
			 current = current.right;
		 }else if(stack.empty())
		 {
			 break;
		 }
	  }
	
  }
  
  @Override/** Preorder traversal from the root non-recursive and using stack */
  public void nonRecursivePreorder()
  {
	  nonRecursivePreorder(root);
  }
  protected void nonRecursivePreorder(TreeNode<E> node)
  {
	  /*
	   * STEP 1: create a stack
	   * STEP 2: assign node (root) as current  
	   * STEP3: start from the root (current)
	   * 	    print the element, then push it into the stack
	   *        then assign left child as new current
	   *        Keep repeating until current node has no child
	   * STEP4: pop the last element of the stack and assign it as new current
	   *        the assign it's right child as new current
	   *        then, repeat step 3
	   */
	  Stack<TreeNode<E>> stack = new Stack<>();//STEP 1
	  TreeNode<E> current = node;//STEP 2
	  
	  while(true)
	  {
		  if(current!=null)//STEP 3
		  {
			  System.out.print(current.element+ " ");
			  stack.push(current);
			  current = current.left;
		  }
		  else if(!stack.isEmpty()) //STEP4
		  {
			  current = stack.pop();
			  current = current.right;
		  }else if(stack.empty())
		  {
			  break;//exit if the stack empty
		  }
	  }
  }
  
  @Override/** Postorder traversal from the root non-recursive and using stack */
  public void nonRecursivePostorder()
  {
	  nonRecursivePostorder(root);
  }
  protected void nonRecursivePostorder(TreeNode<E> node)
  { 
	  /*
	   * This non recursive postorder traversal method using stack and visited flag(visited flag declared as an boolean data field in treeNode static class. 
	   *    By default, all treeNode have visited = false )
	   * STEP 1: create a stack
	   * STEP 2: assign node (root) as current   
	   * STEP 3:  add the current node to the stack
	   * STEP 4: Traverse the tree by using the stack, keep doing this step as long as stack is not empty
	   * 	+ peek the last element of the stack and assign it as current node
	   * 	+ 3 possibilities:
	   * 		1> current node has left child AND it's left child's visited == false, then push the left child to the stack 
	   *        2> current node has right child AND it's right child's visited == false, then push the right child to the stack	 
	   *        3> otherwise: 
	   *        	either current node null or it's children's visited == true, then the current node is printed out and set it's visited as true
	   *        	Finally, that current node popped out of the stack. --> then the next last element of the stack is peeked and assign as current node.
	   */
	  Stack<TreeNode<E>> stack = new Stack<>();//STEP 1
	  TreeNode<E> current = node;//STEP 2
	  stack.push(current);//STEP 3
	  
	  while(!stack.isEmpty())//STEP 4
	  {
		  current = stack.peek();//peek the last element
		  if(current.left!=null && current.left.visited==false)// possibility 1
		  {
			  stack.push(current.left);
		  }else if(current.right!=null && current.right.visited==false)// possibility 2
		  {
			  stack.push(current.right);
		  }else // possibility 3
		  {
			  current.visited=true;
			  System.out.print(current.element + " ");
			  stack.pop();
		  }
	  }
  }
  @Override/** Returns true if the tree is a full binary tree */
  public boolean isFullBST()
  {
	  return (size == (int)Math.pow(2, height()+1)-1) ;
  }
  @Override
  public int getNumberOfLeaves(){
	 if(size==0)
	  {
		  return 0;
	  }else
	  {
		  return getNumberOfLeaves(root);
	  }
  }
  protected int getNumberOfLeaves(TreeNode<E> node)
  {
	  if(isFullBST())
	  {
		  return (int) Math.pow(2, height());
	  }else
	  {
		  int count = 0;
		  Stack<TreeNode<E>> stack = new Stack<>();//STEP 1
		  TreeNode<E> current = node;//STEP 2
		  while(true)
		  { 
			 if(current!=null)//STEP 3
			 {
				 stack.push(current);
				 current=current.left;
			 }else if(!stack.isEmpty())//STEP 4
			 {
				 current=stack.pop();
				 if (current.left==null && current.right==null)
				 {
					 count++;
				 }
				 current = current.right;
			 }else if(stack.empty())
			 {
				 break;
			 }
		  }
		  return count;
	  } 
  } 

  @Override/** Returns the number of nonleaf nodes */
  public int getNumberofNonLeaves()
  {
	  return size-getNumberOfLeaves();
  }
}
