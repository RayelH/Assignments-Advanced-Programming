import java.io.*;


public class Maze {

    char[][] maze = new char[9][9];
    int startX, startY;
    int endX, endY;


    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.findPath();
        maze.printPath();
    }

    public Maze() {
        create();
    }

    public void create() {

        String fileName="C:\\Users\\Rayel\\Documents\\School\\EUR\\Advanced Programming\\Assignments-Advanced-Programming\\Assignment 2\\Question 3\\src\\maze.txt";

        try {


            FileReader inputFile = new FileReader(fileName);
            BufferedReader br = new BufferedReader(inputFile);

            for (int j = 0; j < maze.length; j++) {
                maze[j] = br.readLine().toCharArray();
            }

        } catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }




        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (maze[i][j] == 'F') {
                    endX = i;
                    endY = j;
                }
            }
        }

        maze[startX][startY] = ' ';
        maze[endX][endY] = ' ';

        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(maze[i][j]);
            }
        }


        System.out.println();
        System.out.println(startX);
        System.out.println(startY);
        System.out.println(endX);
        System.out.println(endY);


    }


   public void findPath(){
        findPath(startX, startY);
   }

    public boolean findPath(int x,int y){

        if(x < 0 || x > 8 || y < 0 || y > 8){
            return false;
        }

        if(x == endX && y == endY){
            maze[x][y] = 'x';
            return true;
        }

        if(maze[x][y] == '*' || maze[x][y] == 'o'){
            return false;
        }

        maze[x][y] = 'o';

        if(findPath(x,y-1)){
            return true;
        }

        if(findPath(x+1,y)){
            return true;
        }

        if(findPath(x,y+1)){
            return true;
        }

        if(findPath(x-1,y)){
            return true;
        }

        maze[x][y] = ' ';

        return false;

    }

    public void printPath(){

        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(maze[i][j]);
            }
        }
    }










}
