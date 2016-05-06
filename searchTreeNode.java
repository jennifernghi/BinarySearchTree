/**
  code and algorithm from "Introduction to Java Programming Comprehensive version 10th Edition" by Y. Daniel Liang chapter 25
*/
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
