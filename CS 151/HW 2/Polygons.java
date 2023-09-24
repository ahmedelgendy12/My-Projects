//Ahmed Elgendy
//CS-152
//Problem 2: Polygons
import java.util.Scanner;
public class Polygons {
  public static void main (String[] args){
    
    Scanner scan = new Scanner(System.in);
    
    double sideLength;
    double apothemLength;
    double area;
    int numSide;
    
    System.out.println("What is the length of a side?");
    sideLength = scan.nextDouble();
    
    System.out.println("How many sides?");
    numSide = scan.nextInt();
    
    System.out.println("Length of apothem?");
    apothemLength = scan.nextDouble();
    
    area = Math.abs(sideLength) * Math.abs(numSide) * (Math.abs(apothemLength)/2);
    
    System.out.println("Area is: " + area);
  }  
}  