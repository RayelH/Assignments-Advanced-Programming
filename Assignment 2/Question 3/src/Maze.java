import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class represents a maze that can be solved by using backtracking.
 */
public class Maze {

    char[][] mazeMap;
    int startX, startY;
    int endX, endY;
    String mazeString;

    public static void main(String[] args) {

        Maze maze = new Maze(9,9);
        System.out.println("Original maze: ");
        maze.createExampleMaze();
        maze.printMaze();
        maze.findPath();
        System.out.println("Solved Maze: ");
        maze.printPath();
    }

    /**
     * Constructor for the Maze class.
     *
     * @param height the height of the maze.
     * @param width the width of the maze.
     */
    public Maze(int height, int width) {

        mazeMap = new char[height][width];
        mazeString = "";
    }

    /**
     * Method that creates the example maze given in the assignment
     */
    public void createExampleMaze(){

        mazeString = "*S*******\n" +
                     "*     * *\n" +
                     "* ***** *\n" +
                     "* * *   *\n" +
                     "* * *** *\n" +
                     "*   *   *\n" +
                     "*** * * *\n" +
                     "*     * *\n" +
                     "*******F*";

        // convert string to 2d array
        String[] rows = mazeString.split("\n");

        for(int i = 0; i<mazeMap.length; i++){

            mazeMap[i] = rows[i].toCharArray();
        }

        // find where start and finish are and remove the S and F so maze is ready to be solved
        this.findStartEnd();
        mazeMap[startX][startY] = ' ';
        mazeMap[endX][endY] = ' ';
    }

    /**
     * Method that reads a maze from a text file and stores it as an 2d array.
     * create the text file and copy its path as the input
     *
     * @param filePath the path of the text file from which the maze is read.
     */
    public void readMazeFromFile(String filePath) {

        // read file with maze in it
        try {

            FileReader inputFile = new FileReader(filePath);
            BufferedReader br = new BufferedReader(inputFile);

            // convert to 2d array
            for (int j = 0; j < mazeMap.length; j++) {
                mazeMap[j] = br.readLine().toCharArray();
            }

        } catch(Exception e){

            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        // convert back to string for printing original maze with printMaze method
        for (int i = 0; i < mazeMap.length; i++) {
            for (int j = 0; j < mazeMap[0].length; j++ ) {
                mazeString = mazeString + mazeMap[i][j];
            }
            mazeString = mazeString + "\n";
        }

        // find where start and finish are and remove the S and F so maze is ready to be solved
        this.findStartEnd();
        mazeMap[startX][startY] = ' ';
        mazeMap[endX][endY] = ' ';
    }

    /**
     * Method that finds the path from start to finish by using backtracking
     */
   public boolean findPath(){

        return findPath(startX, startY);
   }

    /**
     * Helper Method that finds the path from start to finish by using backtracking
     *
     * @param x x-coordinate of the point on which we call the method
     * @param y y-coordinate of the point on which we call the method
     * @return true if there exists a path from start to finish, false else.
     */
    public boolean findPath(int x,int y){

       // determine if x,y is inside maze
       if(x < 0 || x > mazeMap[0].length || y < 0 || y > mazeMap.length){
            return false;
        }

        // determine if x,y is the exit of the maze
        if(x == endX && y == endY){
            mazeMap[x][y] = 'x';
            return true;
        }

        // determine if x,y is a wall or the point that you came form
        if(mazeMap[x][y] == '*' || mazeMap[x][y] == 'o'){
            return false;
        }

        mazeMap[x][y] = 'o';

        // search north
        if(findPath(x,y-1)){
            return true;
        }

        // search east
        if(findPath(x+1,y)){
            return true;
        }

        // search south
        if(findPath(x,y+1)){
            return true;
        }

        // search west
        if(findPath(x-1,y)){
            return true;
        }

        mazeMap[x][y] = ' ';

        return false;
    }

    /**
     * Method that prints the maze with the solution path that is found.
     */
    public void printPath(){

        for (int i = 0; i < mazeMap.length; i++) {
            System.out.println("");
            for (int j = 0; j < mazeMap[0].length; j++) {
                System.out.print(mazeMap[i][j]);
            }
        }
    }

    /**
     * Method that prints the original maze without the solution path.
     */
    public void printMaze(){

        System.out.println();
        System.out.println(mazeString);
        System.out.println();
    }

    /**
     * Method that finds the start and endpoint of a maze.
     */
    public void findStartEnd(){

        for (int i = 0; i < mazeMap.length; i++) {
            for (int j = 0; j < mazeMap[0].length; j++) {
                if (mazeMap[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (mazeMap[i][j] == 'F') {
                    endX = i;
                    endY = j;
                }
            }
        }
    }
}
