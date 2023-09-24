//Ahmed Elgendy
//CS-151
//Homework 1 Problem 2 

import java.util.Scanner;

public class TuringTest {
  public static void main (String[] args){
    
    Scanner scan = new Scanner(System.in);
    
    //* The questions are How much money do you owe everyone? Who do you owe this money to? and Why should you pay this money back?*// 
    
    double moneyOwed;
    String personName;
    String reasonWhy;
   
   System.out.println(" How much money do you owe everyone?");
   moneyOwed = scan.nextDouble();
   
   System.out.println("Who do you owe this money to?");
   personName = scan.nextLine();
   personName = scan.nextLine();
   
   
   System.out.println("Why should you pay this money back?");
   reasonWhy = scan.nextLine();
   
   reasonWhy = reasonWhy.replace("I","you");
   
   System.out.println("\n\nyou owe $" + moneyOwed + " that's too much!");
   System.out.println("You should pay " + personName + " back, because you are morally obligated to do so and " + reasonWhy);
   
  }
  
} 