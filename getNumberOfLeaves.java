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
