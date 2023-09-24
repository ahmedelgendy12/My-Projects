
import java.util.Scanner;

/**
 * Some buggy code to practice methodical debugging and creating a test harness.
 * 
 * This code has a few bugs
 * 
 * @author Chad Williams
 *
 */
public class BuggyCode {
  /** Holds the cumulative sum of calls to the add methods */
  private int value = 0;

  /**
   * Creates an instance of the class for collecting the cumulative sum
   */
  public BuggyCode() {

  }

  /**
   * Returns the sum of all numbers that have been added so far
   * 
   * @return Cumulative value
   */
  public int getCumulativeValue() {
    return value;
  }
  // System.out.println("print totalValue = " + totalValue);

  /**
   * Adds the passed value to the sum
   * 
   * @param value New value to be added
   * @return
   */
  // change this. value
  public void add(int value) {
    this.value += value;
  }
  // System.out.println("print value = " + value);

  /**
   * Adds each int in the array to the cumulative sum
   * 
   * @param values New values to be added
   */
  // array started at 0 not at 1
  public void addArray(int[] values) {
    for (int i = 0; i < values.length; i++) {
      add(values[i]);
    }
  }
  // System.out.println("print value = " + value);

  /**
   * Method takes a string with integers separated by spaces and returns an int array Ex. "1 2 3"
   * would return [1,2,3]
   * 
   * @param intArrayString Integers separated by spaces
   * @return int array of passed values
   */
  public static int[] getIntArrayFromString(String intArrayString) {
    String[] intParts = intArrayString.split(" ");
    int[] returnArray = new int[intParts.length];
    int index = 0;
    while (index < intParts.length) {
      returnArray[index] = Integer.parseInt(intParts[index]);
      index++;
    }
    return returnArray;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // declare and initialize variables
    Scanner scan = new Scanner(System.in);
    String inputString = "";

    // Create instance and add numbers entered by user
    BuggyCode code = new BuggyCode();

    System.out.println("Enter first number to add: ");
    int numberEntered = Integer.parseInt(scan.nextLine());
    code.add(numberEntered);
    // System.out.println("number1 =" + numberEntered);

    System.out.println("Enter second number to add: ");
    numberEntered = Integer.parseInt(scan.nextLine());
    code.add(numberEntered);
    System.out.print("Enter a set of numbers each separated by a space: ");
    // System.out.println("number2 =" numberEntered);

    inputString = scan.nextLine();
    int[] intArray = getIntArrayFromString(inputString);
    code.addArray(intArray);

    System.out.println("The total of the values entered is: " + (code.getCumulativeValue()));
  }

}
