# BinarySearchTree
1. Delete: 
      + locate the node contains element and it's parent node
      + current = node contains element
      + parent = current's parent node
      + CASE 1: current doesn't have left child or if current is a leaf
         - connect parent with the right child
      + CASE 2: current has a left child
         - rightMost = node contains the largest element in LEFT subtree of current
            => rightMost can't have a right child, but may have the left child
         - parentOfRightMost = parent node of rightMost
         - current.element = rightMost.element
         - connect parentOfRightMostNode with rightMost.left
         - delete rightMost
         -  if left child of current doesn't have a right child
            + current.left = large elemtn in the left subtree of current
                 - rightMost = current.left
                 - parentOfRightMost = current
            + reconnect right child of rightMost w/ parentOfRightMost
         

    ALGORITHM:
    
        boolean delete(E e){
        
            Locate element e in the tree
            
            if(e !found) return true;
            
            Let current be the node that contains e and parent be the parent of current;
            
            if(current has no left child) //case1 
            
            {
            
                Connect the right child of current with parent
                
                now current is not referenced, so it is eliminated
                
            }else{//case 2
            
                Locate the rightmost ode in the left subtree of current.
                
                copy he element value in the rightmost node to current.
                
                connect the parent of the rightmost node to the left child of rightmost node;
            }
            
            
            return true; //element deleted
        
        }
