/**
 * Homework 1
 * 
 * @author Ahmed Elgendy CS 152-01
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SalespersonOfTheMonth {
  public static void main(String[] args) throws FileNotFoundException {

    Scanner file = new Scanner(new File("salesSlips.txt"));
    // Declare my variables
    int salesPerNum = 0;
    int productNum = 0;
    double amount = 0;
    Double[][] sales = new Double[5][7];

    // Get rid of the nulls
    for (int row = 0; row <= 4; row++) {
      for (int col = 0; col <= 6; col++) {
        sales[row][col] = 0.0;
      }
    }

    String line = file.nextLine();

    // Get the amount
    while (file.hasNextLine()) {
      line = file.nextLine();
      String[] lineArray = line.split(",");
      salesPerNum = Integer.parseInt(lineArray[0]);
      productNum = Integer.parseInt(lineArray[1]);
      amount = Double.parseDouble(lineArray[2]);
      sales[salesPerNum][productNum] += amount;
    }

    // Get the Total
    for (int z = 0; z <= 4; z++) {
      for (int y = 1; y <= 6; y++) {
        sales[z][0] += sales[z][y];
      }
    }
    for (int t = 0; t <= 4; t++) {
      for (int l = 1; l <= 6; l++) {
        sales[0][l] += sales[t][l];
      }
    }
    // Display Table
    System.out.println("\t\t\t\t   Sales Person");
    System.out.println("\t\t Total \t\t1\t\t2\t\t3\t\t4");
    for (int i = 0; i <= 6; i++) {
      System.out.println();
      if (i == 3) {
        System.out.print("Product");
      }
      System.out.print("\t" + i);
      for (int j = 0; j <= 4; j++) {
        System.out.printf("\t%.2f\t", sales[j][i]);
      }

    }
  }
}


