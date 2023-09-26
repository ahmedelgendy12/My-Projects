/*
 * Ahmed Elgendy
 * CS-152
 * Problem 2
 */
import java.util.Scanner;

public class Keyboard {
  Scanner scan = new Scanner(System.in);
  NoDigitsException problem = new NoDigitsException();

  public int getInt() throws NoDigitsException {
    // take user input
    String input = scan.nextLine();
    String acceptInt = "0123456789";
    String result = "";
    // iterate through the String
    for (int index = 0; index < input.length(); index++) {
      char letter = input.charAt(index);
      if (acceptInt.indexOf(letter) > -1) {
        result += letter;
      }
    }
    if (result.equals("")) {
      throw problem;
    }
    int finalResult = Integer.parseInt(result);
    return finalResult;
  }

  public int getIntPrompt(String prompt) throws NoDigitsException {
    System.out.println(prompt);
    return getInt();
  }

  public double getDouble() throws NoDigitsException {
    int count = 0;
    // take user input
    String input = scan.nextLine();
    String acceptDouble = ".0123456789";
    String result = "";
    // iterate through the String
    for (int index = 0; index < input.length(); index++) {
      char letter = input.charAt(index);
      // Checks for '.' and if the second one was typed in replace with 'a'
      if (letter == '.') {
        count++;
        if (count > 1) {
          letter = 'a';
        }
      }
      if (acceptDouble.indexOf(letter) > -1) {
        result += letter;
      }
    }
    if (result.charAt(result.length() - 1) == '.') {
      result += '0';
    }

    if (result.equals("")) {
      throw problem;
    }
    double finalResult = Double.parseDouble(result);

    return finalResult;
  }


  public Double getDoublePrompt(String prompt) throws NoDigitsException {
    System.out.println(prompt);
    return getDouble();
  }
}
