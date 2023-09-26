
/**
 * @author Ahmed Elgendy
 * Extra Credit
 * FourInARow
 */

import  java.lang.*;
import java.util.Scanner;

public class FourInARow{
    public static void main(String[] args)
    throws InterruptedException{
        boolean carryon = true;
        int column = 0;
        int y = 4;
        int redWins = 0;
        int blueWins = 0;
        int optionInt = 0;
        String optionString = " ";
        Scanner scan = new Scanner(System.in);
        Game game1 = new Game();

        while(carryon){
            for(int i = 0; i < 33; i++){
                System.out.println(" ");
            }
            System.out.println("Games won:   Blue: " + blueWins + "  Red: " + redWins);
            System.out.println("#######  Menu  #######");
            System.out.println("1: Start a game");
            System.out.println("2: Reset Scores");
            System.out.println("3: Exit");
            System.out.println("Choose your Destiny!");

            optionInt = scan.nextInt();
            switch (optionInt){
                case 1: 
                int player = 1;int turn = 1;
                boolean winner = false;
                int[][] grid = 
                    {
                        {0,0,0,0,0}, 
                        {0,0,0,0,0}, 
                        {0,0,0,0,0}, 
                        {0,0,0,0,0}, 
                        {0,0,0,0,0}, 
                    };

                game1.setGrid(grid);
                while(!winner && turn < 25){
                    boolean validPlay;
                    turn++;
                    player = turn % 2;
                    if (player == 0){
                        System.out.println("Player 1 Turn");
                        System.out.println("What column (0,1,2,3,4)?");
                        boolean badInput = true;
                        while(badInput){
                            column = scan.nextInt();
                            if(column >= 0 && column < 5 && grid[column][0] == 0){
                                badInput = false;
                            } else {
                                System.out.println("HEY bad input, Feel bad :(");
                                System.out.println("Player 1 turn");
                                System.out.println("What column (0,1,2,3,4)?");
                            }
                        }
                        y = 4;
                        while(grid[column][y] != 0 && y > -1){
                            y--;
                        }
                        game1.setSpot(column,y,1);
                        grid[column][y] = 1;
                        game1.setGrid(grid);
                        for(int z = 0; z < 33; z++){
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("Player 2 turn");
                        System.out.println("What column (0,1,2,3,4)?");
                        boolean badInput = true;
                        while(badInput){
                            column = scan.nextInt();
                            if(column >= 0 && column < 5 && grid[column][0] == 0){
                                badInput = false;
                            } else {
                                System.out.println("HEY bad input, Feel bad :(");
                                System.out.println("Player 1 turn");
                                System.out.println("What column (0,1,2,3,4)?");
                            }
                        }
                        y = 4;
                        while(grid[column][y] != 0 && y > -1){
                            y--;
                        }
                        game1.setSpot(column,y,2);
                        grid[column][y] = 2;
                        game1.setGrid(grid);
                        for(int k = 0; k < 33; k++){
                            System.out.println(" ");
                        }
                    }

                    // Blue player wins check
                    if(grid[1][4] == 1 && grid[2][4] == 1 && grid[3][4] == 1 && (grid[0][4] == 1 || grid[4][4] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][3] == 1 && grid[2][3] == 1 && grid[3][3] == 1 && (grid[0][3] == 1 || grid[4][3] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][2] == 1 && grid[2][2] == 1 && grid[3][2] == 1 && (grid[0][2] == 1 || grid[4][2] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][1] == 1 && grid[2][1] == 1 && grid[3][1] == 1 && (grid[0][1] == 1 || grid[4][1] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][0] == 1 && grid[2][0] == 1 && grid[3][0] == 1 && (grid[0][0] == 1 || grid[4][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}

                    if(grid[0][1] == 1 && grid[0][2] == 1 && grid[0][3] == 1 && (grid[0][4] == 1 || grid[0][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1 && (grid[1][4] == 1 || grid[1][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[2][1] == 1 && grid[2][2] == 1 && grid[2][3] == 1 && (grid[2][4] == 1 || grid[2][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[3][1] == 1 && grid[3][2] == 1 && grid[3][3] == 1 && (grid[3][4] == 1 || grid[3][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[4][1] == 1 && grid[4][2] == 1 && grid[4][3] == 1 && (grid[4][4] == 1 || grid[4][0] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}

                    if(grid[1][3] == 1 && grid[2][2] == 1 && grid[3][1] == 1 && (grid[4][0] == 1 || grid[0][4] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[3][3] == 1 && grid[2][2] == 1 && grid[1][1] == 1 && (grid[0][0] == 1 || grid[4][4] == 1)){winner = true; System.out.println("Blue Player wins");blueWins++;}
                    if(grid[1][4] == 1 && grid[2][3] == 1 && grid[3][2] == 1 && grid[4][1] == 1){winner = true; System.out.println("Blue Player wins"); blueWins++;}
                    if(grid[0][3] == 1 && grid[1][2] == 1 && grid[2][1] == 1 && grid[3][0] == 1){winner = true; System.out.println("Blue Player wins"); blueWins++;}
                    if(grid[3][4] == 1 && grid[2][3] == 1 && grid[1][2] == 1 && grid[0][1] == 1){winner = true; System.out.println("Blue Player wins"); blueWins++;}
                    if(grid[4][3] == 1 && grid[3][2] == 1 && grid[2][1] == 1 && grid[1][0] == 1){winner = true; System.out.println("Blue Player wins"); blueWins++;}

                    // Red player wins check
                    if(grid[1][4] == 2 && grid[2][4] == 2 && grid[3][4] == 2 && (grid[0][4] == 2 || grid[4][4] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 2 && (grid[0][3] == 2 || grid[4][3] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 2 && (grid[0][2] == 2 || grid[4][2] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 2 && (grid[0][1] == 2 || grid[4][1] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][0] == 2 && grid[2][0] == 2 && grid[3][0] == 2 && (grid[0][0] == 2 || grid[4][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}

                    if(grid[0][1] == 2 && grid[0][2] == 2 && grid[0][3] == 2 && (grid[0][4] == 2 || grid[0][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 2 && (grid[1][4] == 2 || grid[1][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 2 && (grid[2][4] == 2 || grid[2][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 2 && (grid[3][4] == 2 || grid[3][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[4][1] == 2 && grid[4][2] == 2 && grid[4][3] == 2 && (grid[4][4] == 2 || grid[4][0] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}

                    if(grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 2 && (grid[4][0] == 2 || grid[0][4] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[3][3] == 2 && grid[2][2] == 2 && grid[1][1] == 2 && (grid[0][0] == 2 || grid[4][4] == 2)){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[1][4] == 2 && grid[2][3] == 2 && grid[3][2] == 2 && grid[4][1] == 2){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[0][3] == 2 && grid[1][2] == 2 && grid[2][1] == 2 && grid[3][0] == 2){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[3][4] == 2 && grid[2][3] == 2 && grid[1][2] == 2 && grid[0][1] == 2){winner = true; System.out.println("Red Player wins");redWins++;}
                    if(grid[4][3] == 2 && grid[3][2] == 2 && grid[2][1] == 2 && grid[1][0] == 2){winner = true; System.out.println("Red Player wins");redWins++;}
                }    

                break;
                case 2:
                redWins = 0;
                blueWins = 0;
                break;
                case 3: 
                carryon = false;
                break;
                default:
                System.out.println("Invalid Entry");
            }
        }
        System.out.println("Thank you for playing!");

    }
}

