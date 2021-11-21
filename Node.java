public class Node {

        int x; //x cordnaite
        int y; //y cordnaite


        Node right;
        Node top;
        Node bottom;
        Node left;


        Node next;

        boolean obctical;  
        boolean visited;

        Node(int x, int y, boolean obctical) {
            this.x = x;
            this.y = y;
            this.right = null;
            this.top = null;
            this.bottom = null;
            this.left = null;
            this.obctical = obctical;
            visited = false;
        }
   
 

        void setVisit(boolean visited) {
            this.visited = visited;
        }
    
        void setUnvisit() {
            visited = false;
        }
        void removeObctical(){
            obctical=false;
        }
        void setObctical( boolean obctical){
            this.obctical=obctical;
        }

        //setters and getters
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
        boolean getObctical(){
            return obctical;
        }
        boolean getVisited(){
        return visited;
        }
  
        
    }
