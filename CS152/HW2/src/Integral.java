/*
 * Ahmed Elgendy
 * CS-152
 * Problem 2
 */
import java.util.Scanner;

public class Integral {

  static Scanner scan = new Scanner(System.in);

  // Method for the quadratic equation the variables a,b,c refers to the math standard equation
  // F(x)=ax^2+bx+c
  public static double quadratic(double variableX, double variableA, double variableB,
      double variableC) {
    double value = (variableA * variableX * variableX) + (variableB * variableX) + variableC;
    return value;
  }


  // Method to get the Riemann Sum
  // In this method the variables a,b,c,and x refers to the math standard equation F(x)=ax^2+bx+c
  public static double leftRiemannSum(double variableA, double variableB, double variableC,
      double left, double right, double numOfBins) {
    double variableX = 0;

    double totalArea = 0;

    do {
      double binWidth = (right - left) / numOfBins;
      double binArea = binWidth * quadratic(variableX, variableA, variableB, variableC);
      variableX += binWidth;
      totalArea += binArea;
    } while (variableX < right);

    return totalArea;


  }

  // Method for the quadratic equation the variables A,B,C refers to the math standard equation
  // User input and finding the tolerence
  public static void main(String[] args) {

    System.out.println("For the math standard equation F(x)=ax^2+bx+c.");
    System.out.println("Enter variable A:");
    double variableA = scan.nextDouble();
    System.out.println("Enter variable B:");
    double variableB = scan.nextDouble();
    System.out.println("Enter variable C:");
    double variableC = scan.nextDouble();
    System.out.println("Enter the left:");
    double left = scan.nextDouble();
    System.out.println("Enter the right:");
    double right = scan.nextDouble();
    System.out.println("Enter the tolerence:");
    double tolerence = scan.nextDouble();

    double numOfBins = 1;
    double currentArea = 0;
    double oldArea = 0;
    do {
      numOfBins++;
      currentArea = leftRiemannSum(variableA, variableB, variableC, left, right, numOfBins);
      oldArea = leftRiemannSum(variableA, variableB, variableC, left, right, numOfBins - 1);
    } while (Math.abs(currentArea - oldArea) > tolerence);



    System.out.println(
        "For the tolerence of " + tolerence + ",\nthe total area would be " + currentArea + ".");
  }

}
