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
