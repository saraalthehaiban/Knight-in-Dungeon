public class Node {

        int x; //x cordnaite
        int y; //y cordinate
        boolean obctical; 
        boolean visited; 
    
        Node(int x, int y, boolean obctical) {
            this.x = x;
            this.y = y;
            this.obctical = obctical;
            visited = false;
        }
   
 

        void setVisit() {
            visited = true;
        }
    
        void setUnvisit() {
            visited = false;
        }
        void removeObctical(){
            obctical=false;
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
