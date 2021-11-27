import java.util.*;

public class Input{
    public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in); //Scanner declaration to read from the user
       int rows = 0; //number of rows in the 2D array
       int columns = 0; //number of columns in the 2D array

       System.out.printf("Welcome, to design your Dungeon’s floor map\nplease enter the number of rows:\n");
        do{ //checks if the number is not an integer
            try{
                rows = sc.nextInt(); //get the number of rows from the user
                while(rows <= 0){ //checking if the number of rows is negative
                    System.out.println("Invalid row size, please try again.");
                    rows = sc.nextInt();
                 }
               } catch(java.util.InputMismatchException e){
                    System.out.println("Invalid row size, please try again.");
               }
               sc.nextLine(); //clears the buffer
        }while(rows <= 0);
        
       System.out.println("Please enter the number of columns:");
       do{ //checks if the number is not an integer
            try{
                columns = sc.nextInt(); //get the number of columns from the user
                while(columns <= 0){ //checking if the number of columns is negative
                    System.out.println("Invalid column size, please try again.");
                    columns = sc.nextInt();
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Invalid column size, please try again.");
            }
            sc.nextLine(); //clears the buffer
       }while(columns <= 0);
       
       
       int twoD[][] = new int[rows][columns]; //2D array declaration

       System.out.println("Please enter the number of obstacles:");
       int obstacles = -1; //number of obstacles to be added
       do{ //checks if the number is not an integer
            try{
                obstacles = sc.nextInt(); //get the number of obstacles from the user
                while((obstacles > (rows * columns))||(obstacles<0)){ //checking if the number of obstacles is more than the map size
                    System.out.println("Invalid obstacles number, please try again.");
                    obstacles = sc.nextInt();   
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Invalid obstacles number, please try again.");
            }
            sc.nextLine(); //clears the buffer
        }while(obstacles < 0);
       
       if(obstacles != 0){
        System.out.println("Please enter the obstacles location (ex: 1 3) then press enter to type the next location:");

        for(int i = 0; i < obstacles; i++){
            try{
             //get the location of obstacles from the user
             int obRow = sc.nextInt(); //get the row for the location
             int obCol = sc.nextInt(); //get the columns for the location
             if(twoD[obRow][obCol] == 1){ //checks if the location exists
                 System.out.println("Already taken, please enter another location.");
                 i--;
             }
             else if(obCol== 0 && obRow==0){ //checks if the location exists
                System.out.println("Input cannot be equal to the start position, Please enter another location.");
                sc.nextLine();
                i--;
            }
            else if(obRow==rows-1 && obCol==columns-1){ //checks if the location exists
                System.out.println("Input cannot be equal to the end position, Please enter another location.");
                sc.nextLine();
                i--;
            }
            else
             twoD[obRow][obCol] = 1; //adds the obstacles to the map
            }
            catch (java.lang.ArrayIndexOutOfBoundsException e){
                 System.out.println("Invalid location, please try again.");
                 i--;
            }catch(java.util.InputMismatchException e){
                 System.out.println("Invalid location, please try again.");
                 sc.nextLine();
                 i--;
            }
           
        }
        System.out.println("Please enter the number of obstacles to remove:");
       int obs = -1;
       do{ //checks if the number is not an integer
            try{
                obs = sc.nextInt(); //get the number of obstacles to be removed from the user
                while(obs < 0){ //checking if the number of obstacles to be removed is negative
                    System.out.println("Invalid obstacles number, please try again.");
                    obs = sc.nextInt();
                }
            } catch(java.util.InputMismatchException e){
                    System.out.println("Invalid obstacles number, please try again.");
            }
            sc.nextLine(); //clears the buffer
        }while(obs < 0);

        path(twoD, obs); //With K obstacles
        path(twoD, 0); //With 0 obstacles
       } else{
        path(twoD, 0); //With 0 obstacles
       }


       //test print
       System.out.print("\nData you entered (map): \n");
       for(int []x:twoD){
           for(int y:x){
           if(y == 0)
           System.out.print('-'+"        ");
           if(y == 1)
           System.out.print('X'+"        ");
           }
           System.out.println();
       }
    }
      // map[x][y] - if any cell value is 1, it means it is an obstacle; if 0, it is an empty cell
      //Method that returns the minimum path when a 2d map is given with the number of removable obstacles
      public static void path(int[][] map, int k) {

        //Step 1: Set up variables and queue 
        // Arrays used to go right, left, down, and up
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        //boolean 2d array of visited positions in the map – true if visited (indicated whether a position is visited or not – explored set)
        boolean[][] visited = new boolean[map.length][map[0].length];
        //int 2d int array of number number of removal obstacles at each position (indicates if we can move to a new node at a given position or not)
        int[][] obstaclesLeft = new int[map.length][map[0].length];
        //Node 2d array of parent nodes (indicates how we arrived to the current node – solution path)  
        Node[][] parent = new Node[map.length][map[0].length];
        //Queue of nodes implemented with LinkedList
        Queue<Node> q = new LinkedList<>(); // – frontier

        //Step 2.1: Adding first node to queue 
        // We start by putting the first node of coordinate (0, 0) into the queue
        q.add(new Node(0, 0, k)); 

        //Parent of the first node is null, since it is the start of the path (0,0)
        parent[0][0] = null;

        //The number of steps taken by the knight to reach the princess
        int steps = 0;

        //Step 2.2: Traversing the queue of nodes until the queue is empty using the BFS technique
        while (!q.isEmpty()) {
            int size = q.size(); //Handling each node 
            for (int i = 0; i < size; i++) {
                Node node = q.poll(); //The poll() method returns and removes the element at the front end of the container (take it out of the frontier)
                //Step 2.2.1: Goal test
                //Is the current node from the queue the goal node (in the bottom-right corner)?
                if(node.getX() == map.length - 1 && node.getY() == map[0].length - 1) {
                  //Step 2.2.2: Goal set up
                  ArrayList<Node> arr = new ArrayList<>();//Stores the path by backtracking to the start node
                  ArrayList<Node> nodesRemoved = new ArrayList<>(); //Needed for getting the position of nodes with removed obstacles
                  //Add the end node into the arraylist
                  arr.add(node);
                  //Get the parent of the end node
                  Node parentNode = parent[node.getX()][node.getY()];

                  //Step 2.2.3: Get solution path using array of parents (fill in arr) and get positions of nodes where obstacles were removed (fill in nodesRemoved)
                  //Backtrack to the start node
                  while(parentNode!=null && !(parentNode.getX()==0 && parentNode.getY()==0)){ //Checks if the parent node is not the start node
                    if(map[parentNode.getX()][parentNode.getY()] == 1) //If there was an obstacle in the position, then it was removed 
                      nodesRemoved.add(parentNode);
                    arr.add(parentNode);//Always add the parent node to the arr to get the full path
                    parentNode = parent[parentNode.getX()][parentNode.getY()];//Get the parent of the current parent node
                  }
                  arr.add(parentNode);//Add the start (0,0) node into the arr

                  //Step 2.2.4: Print the output which includes the k, positions of removed obstacles, number of steps taken, and full path from (0,0) to (M-1, N-1)
                  System.out.print("The shortest path with " + k + " obstacle elimination ");
                  if(nodesRemoved.size() != 0){ //If k=0 or no obstacles were removed, this will no print anything since no obstacles were removed
                    System.out.print("at position ");
                  }
                  for(int j = nodesRemoved.size() - 1; j >=0; j--){ //If k=0 or no obstacles were removed, this will no print anything since no obstacles were removed
                    System.out.print("("+nodesRemoved.get(j).getX()+", "+nodesRemoved.get(j).getY()+") ");
                  }
                  System.out.print("is " + steps); //Print steps
                  System.out.print(". Such path is ");
                  for(int j = arr.size() - 1; j >=0; j--){//Print path
                    System.out.print("("+arr.get(j).getX()+", "+arr.get(j).getY()+")");
                    if(j==0){
                      System.out.println('.');
                    }
                    else System.out.print(" -> ");
                  }
                  return; //Return since we found a path 
                }


                //Step 2.2.5: Choose the next node using BFS
                // If the current node is not the last node (not in the bottom-right corner)
                for (int j = 0; j < 4; j++) { //4 = all possible movements ( 1- right, 2- left, 3- down, 4- up) using direction arrays in set up

                    int x = node.getX() + dx[j]; 
                    int y = node.getY() + dy[j]; 

                    // If the x and y coordinates are out of the map, do nothing and continue to the next iteration
                    if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                        continue;
                    }
                    
                    // If the new node is already visited and obstaclesLeft for the new node is greater than equal to the obstacles that can removed for the current node, do nothing and continue to the next iteration
                    if (visited[x][y] && obstaclesLeft[x][y] >= node.getK()) {
                        continue;
                    }

                    //If the new node is an obstacle and the obstacles that can removed for the current node is already 0, you cant visit this new node and will continue to check the next nodes so do nothing and continue to the next iteration
                    if (map[x][y] == 1 && node.getK() == 0) {
                        continue;
                    }

                    //If the the new cell (x,y) is an obstacle, we need to update the number of obstacles that can be removed for the next node– (k = number of obstacles left to remove for the current node - 1)
                    int obstaclesLeftNow = node.getK() - map[x][y];
                    // Add the node into the queue
                    q.add(new Node(x, y, obstaclesLeftNow));
                    //Update the obstacles array
                    obstaclesLeft[x][y] = obstaclesLeftNow;
                    //Mark the node as visited 
                    visited[x][y] = true;
                    //Make the current node the parent of the new node
                    parent[x][y] = node; 
                }
            }
            //Increment the step steps
            steps++; 
        }
        //Step 2.2.6: Print -1 when there is not path (return line hasn't been reached)
        System.out.print("The shortest path with " + k + " obstacle elimination \n");
        System.out.println("-1");
        System.out.println("No solution is found! We need to eliminate more obstacles to find such a walk.");
    }

}