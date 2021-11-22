import java.util.Scanner;

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
                while(obstacles < 0){ //checking if the number of obstacles is negative
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
        System.out.println("Please enter the obstacle to remove:");
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
       }

        //Create the class object
        //objectName.methodname(twoD, obs);

       //test print
       System.out.print("\nData you entered: \n");
       for(int []x:twoD){
           for(int y:x){
           System.out.print(y+"        ");
           }
           System.out.println();
       }

    }

}