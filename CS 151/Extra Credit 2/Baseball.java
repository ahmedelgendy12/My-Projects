/**
 * Homework 5 Baseball
 * @author Ahmed Elgendy
 * CS 151-03
 */

import java.io.*;
import java.util.*;

public class Baseball  {
    public static void main (String[] args) throws FileNotFoundException{

        Scanner file = new Scanner (new File("2004CCSUBaseball.txt"));

        double atBats = 0.0;
        double RBI = 0.0;
        double total = 0.0;
        int playerCounter = 0;
        String[][] top3 = new String[3][23];
        top3 [0] = "Mike Lombardo,0.297,49,165,43,49,7,0,0,0,56,0.339,36,4,28,6,0.434,0,4,102,132,5,0.979".split(",");
        top3 [1] = "Mike Lombardo,0.297,49,165,43,49,7,0,0,0,56,0.339,36,4,28,6,0.434,0,4,102,132,5,0.979".split(",");
        top3 [2] = "Mike Lombardo,0.297,49,165,43,49,7,0,0,0,56,0.339,36,4,28,6,0.434,0,4,102,132,5,0.979".split(",");

        String line = file.nextLine();

        while (file.hasNextLine()) {
            line = file.nextLine();
            String[] lineArray = line.split(",");
            if (playerCounter < 3){
                top3 [playerCounter] = lineArray;
            }
            RBI = Double.parseDouble(lineArray[9]);
            atBats = Double.parseDouble(lineArray[3]);

            if (atBats > 25){
                playerCounter++;
                total += (RBI / atBats);
                if(playerCounter >= 3){
                    
                    double RBI3 = Double.parseDouble(top3[2][9]);
                    double atBats3 = Double.parseDouble(top3[2][3]);
                    double ER3 = (RBI3 / atBats3);

                    double RBI2 = Double.parseDouble(top3[1][9]);
                    double atBats2 = Double.parseDouble(top3[1][3]);
                    double ER2 = (RBI2 / atBats2);

                    double RBI1 = Double.parseDouble(top3[0][9]);
                    double atBats1 = Double.parseDouble(top3[0][3]);
                    double ER1 = (RBI1 / atBats1);

                    if ( (RBI / atBats) > ER3){
                        if((RBI / atBats) > ER1){
                            top3[2] = top3[1];
                            top3[1] = top3[0];
                            top3[0] = lineArray;   
                        } else if ((RBI / atBats) > ER2){
                            top3[2] = top3[1];
                            top3[1] = lineArray; 
                        } else {
                            top3[2] = lineArray; 
                        }
                    }
                }
            }

        }
        total = total/playerCounter;
        System.out.println("The team average ER: " + total);
        System.out.println("The top 3 players: \n" + top3[0][0]);
        System.out.println(top3[1][0]);
        System.out.println(top3[2][0]);
        
        file.close();
    }
}