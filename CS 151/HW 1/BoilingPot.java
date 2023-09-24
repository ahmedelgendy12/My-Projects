//Ahmed Elgendy
//CS-151
//Homework 1 problem 3
import java.util.Scanner;
public class BoilingPot{
  public static void main (String[] args){
  
  Scanner scan = new Scanner(System.in);
  
  double waterDepth;
  double startingTemperture;
  double timeMinutes;
  double tempChangeNeeded;
  double caloriesNeeded;
  double timeSeconds;
  
  System.out.println("How deep is the water?");
  waterDepth = scan.nextDouble();
  
  System.out.println("how warm is the water");
  startingTemperture = scan.nextDouble();
  
  final double PI = 3.141592654;
  final double VOLUME = PI * 10 * 10 * waterDepth;
  tempChangeNeeded = 100 - startingTemperture;
  caloriesNeeded = tempChangeNeeded * VOLUME;
  timeSeconds = caloriesNeeded / 250;
  timeMinutes = timeSeconds / 60;
  
  System.out.println("Minutes until boiling: "+ timeMinutes);

  
  
  
  }
}