/**
 * Homework 1
 * 
 * @author Ahmed Elgendy CS 152-01
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SalespersonOfTheMonth {
  public static void main(String[] args) throws FileNotFoundException {

    Scanner file = new Scanner(new File("salesSlips.txt"));

    int salesPerNum = 0; 
    double productNum = 0;
    double amount = 0;
    double total = 0;
    String[][] sales = new String[2][500];

    String line = file.nextLine();

    while (file.hasNextLine()) {
      line = file.nextLine();
      String[] lineArray = line.split(",");
      salesPerNum = Integer.parseInt(lineArray[0]);
      productNum = Integer.parseInt(lineArray[1]);
      amount = Double.parseDouble(lineArray[2]);

      if (salesPerNum == 1) {
        if (productNum == 1) {
          double amount11 = amount;

          System.out.println(amount11);
        }
        if (productNum == 2) {
          double amount12 = amount;
        }
        if (productNum == 3) {
          double amount13 = amount;
        }
        if (productNum == 4) {
          double amount14 = amount;
        }
        if (productNum == 5) {
          double amount15 = amount;
        }
        if (productNum == 6) {
          double amount16 = amount;
        }
      }

    }

  }

}
