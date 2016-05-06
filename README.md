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
            
            if(e !found) return false;
            
            Let current be the node that contains e and parent be the parent of current;
            
            if(current has no left child) //case1 
            
            {
            
                Connect the right child of current with parent
                
                now current is not referenced, so it is eliminated
                
            }else{//case 2
            
                Locate the rightmost node in the left subtree of current.
                
                copy the element value of the rightmost node to current.
                
                connect the parent of the rightmost node to the left child of rightmost node;
            }
            
            
            return true; //element deleted
        
        }

2. search
     + start from root and scan down from it until a match found or you arrive at 1 empty subtree
     + ALGORITHM
     
      boolean search(E e)
      
      {

            current = root;
        
            while(current!=null)
        
            {      
                  if(e < current.element)
            
                  {
                  
                        current = current.left;
                  
                  }
            
                  else if(e > current.element)
            
                  {
                  
                        current = current.right;
                  
                  }else//match found
                  
                        return true;
              
            }
        
             return false;
        
     }
     
     
Time complexity:
inorder, preorder, postorder: O(n)
search, insertion, deletion: height of three: worst O(n) 
                                              well-balanced O(logn)
