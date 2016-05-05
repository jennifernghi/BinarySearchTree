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
