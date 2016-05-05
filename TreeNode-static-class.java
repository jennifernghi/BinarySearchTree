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
