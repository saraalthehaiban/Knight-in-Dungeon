
public class Graph {
    Node head; 


    
    void insertNode(Node current,Node top, Node right, Node bottom,Node left) {
        current.right = right;
        current.top = top;
        current.bottom = bottom;
        current.left = left;

    }

   void DeleteEdge(Node current) {
        current.right = null;
        current.left = null;

    }

Node retrieveRightNode(Node current){
return current.right;

}
Node retrieveTopNode(Node current){
    return current.top;
 
}
Node retrievebottomNode(Node current){
    return current.bottom;
    
    }
    Node retrieveLeftNode(Node current){
        return current.left;
        
        }
        Node retrieveHeadNode(Graph list){
            return list.head;
            
            }     
    
        public static Graph insert(Graph list, int x,int y,boolean obctical)
        {
            // Create a new node with given data
            Node new_node = new Node(x, y, obctical);
            new_node.next = null;
       
            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            }
            else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }
       
                // Insert the new_node at last node
                last.next = new_node;
            }
       
            // Return the list by head
            return list;
        }
       
        // Method to print the LinkedList.
        public static void printList(Graph list)
        {
            int x=0;
            Node currNode = list.head;
        
        
            // Traverse through the LinkedList
            while (currNode != null) {
                if(currNode.x!=x){
                    x++;
                System.out.print("\n");
                }
                // Print the data at current node
                if(currNode.getObctical()){
                System.out.print("(" +currNode.x + "," +currNode.y +")\" ");
                } else
                System.out.print("(" +currNode.x + "," +currNode.y +") ");

                // Go to next node
                currNode = currNode.next;
            }
            System.out.print("\n");

        }
        
  
        public static Graph deleteByKey(Graph list, int x,int y){

            // Store head node
                  Node currNode = list.head;
                  Node prev = null;


            // If head node itself holds the key to be deleted
            if (currNode != null && currNode.x == x && currNode.y == y) {
          list.head = currNode.next; // Changed head
         System.out.println(x+","+y + " found and deleted");

                         return list;
                          }


// If the key is somewhere other than at head

// Search for the key to be deleted,
// keep track of the previous node
// as it is needed to change currNode.next
while (currNode != null && currNode.x != x || currNode.y != y) {
    // If currNode does not hold key, continue to next node
    prev = currNode;

    if (currNode.next == null){
        break;
  
    }
    currNode = currNode.next;
    }

// If the key was present, it should be at currNode
// Therefore the currNode shall not be null
if (currNode != null) {
    // Since the key is at currNode
    // Unlink currNode from linked list
    prev.next = currNode.next;
}

if (currNode != null && currNode.x == x && currNode.y == y) {
// Display the message
System.out.println(x+","+y + " found and deleted");
return list;
}


// The key is not present

// If key was not present in linked list
// currNode should be null
if (currNode == null) {
// Display the message
System.out.println(x+","+y  + " not found");
}

System.out.println(x+","+y  + " not found");

// return the List
return list;
}

public static Node searchByKey(Graph list, int x,int y){

    // Store head node
            Node currNode = list.head;
            Node prev = null;
    
    
    // If head node itself 
    if (currNode != null && currNode.x == x && currNode.y == y) {
    
        System.out.println(x+","+y + " is the head");
    
        return currNode;
        }
    
    
    // If the key is somewhere other than at head
    
    // Search for the position to be found,
    // keep track of the previous node
    // as it is needed to change currNode.next
    while (currNode != null && (currNode.x != x || currNode.y != y)) {
        // If currNode does not hold key, continue to next node
        prev = currNode;

        if (currNode.next == null){
            break;
      
        }
        currNode = currNode.next;
        
}


    
    if (currNode != null && currNode.x == x && currNode.y == y) {
    // Since the key is at currNode
    System.out.println(x+","+y + " found");
    return currNode;
    }
    
    
    // The key is not present
    // If key was not present in linked list
    // currNode should be null

    System.out.println(x+","+y  + " not found");
    return prev;
  
    }


        public static void main(String[] args)
        {
            /* Start with the empty list. */
            Graph list = new Graph();
       
            // Insert the values
            insert(list, 0,0,false);
            insert(list, 0,1,true);
            insert(list, 0,2,true);

            insert(list, 1,0,false);
            insert(list, 1,1,false);
            insert(list, 1,2,false);

            insert(list, 2,0,false);
            insert(list, 2,1,false);
            insert(list, 2,2,true);
          
       
            // Print the LinkedList
            printList(list);
            Node found =searchByKey(list, 0, 2);
            found.removeObctical();
            printList(list);
           // deleteByKey(list, 1, 1);
           // printList(list);
   

        
    }
}