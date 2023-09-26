/*
 * Ahmed Elgendy
 * Extra Credit #1
 * CS-152
 */
public class TwoDArray {

  // prints the array as [col][row] with [0][0] at Top Left
  public static void printTL(double[][] array) {
    for (int row = 0; row < array[row].length; row++) {
      for (int col = 0; col < array.length; col++) {
        System.out.print(array[col][row] + " ");
      }
      System.out.println();
    }
  }

  // prints the array as [col][row] with [0][0] at Top Right
  public static void printTR(double[][] array) {
    for (int row = 0; row < array[row].length; row++) {
      for (int col = array.length - 1; col >= 0; col--) {
        System.out.print(array[col][row] + " ");
      }
      System.out.println();
    }
  }

  // prints the array as [row][col] with [0][0] at Bottom Left
  public static void printBL(double[][] array) {
    for (int row = array.length - 1; row >= 0; row--) {
      for (int col = 0; col < array[col].length; col++) {
        System.out.print(array[row][col] + " ");
      }
      System.out.println();
    }
  }

  // prints the array as [row][col] with [0][0] at Bottom Right
  public static void printBR(double[][] array) {
    for (int row = array.length - 1; row >= 0; row--) {
      for (int col = array[0].length - 1; col >= 0; col--) {
        System.out.print(array[row][col] + " ");
      }
      System.out.println();
    }
  }


}
