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
