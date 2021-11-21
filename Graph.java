import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    private HashMap<Node, LinkedList<Node>> Map;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        Map = new HashMap<>();
    }
    
    void insertNode(Node current, Node right, Node left) {
        current.right = right;
        current.left = left;

    }

   void DeleteEdge(Node current) {
        current.right = null;
        current.left = null;

    }

Node RetrieveRight(Node current){
return current.right;

}
Node retrieveLeftNode(Node current){
    return current.left;
 
}}