public class Node { //Node represents a position (cell) in the map

            private int x; //x-coordinate
            private int y; //y-coordinate
            private int k; //number of obstacles that can be removed to reach the end node


            //Constructor to initialize x, y, and k
            Node(int x, int y, int k) {
                this.x = x;
                this.y = y;
                this.k = k;
            }

            //Getters
            public int getX(){
                return x;
            }

            public int getY(){
                return y;
            }

            public int getK(){
                return k;
            }
}
