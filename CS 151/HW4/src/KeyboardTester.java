/*
 * Ahmed Elgendy
 * CS-152
 * Problem 3
 */

public class KeyboardTester {

  public static void main(String[] args) throws NoDigitsException {
    int banned = 0;
    Keyboard key = new Keyboard();
    while (true) {
      try {
        int test1 = key.getIntPrompt("Enter an Integer: ");
        System.out.println(test1);

        int test2 = key.getInt();
        System.out.println(test2);

        double test3 = key.getDoublePrompt("Enter an Double: ");
        System.out.println(test3);

        double test4 = key.getDouble();
        System.out.println(test4);


      } catch (NoDigitsException exception) {
        banned++;
        System.out.println(exception);
        if (banned >= 2) {
          System.out.println("Yeah I think were done here :( ");
          System.exit(0);
        }
      } catch (Exception justExpection) {
        banned++;
        System.out.println("Bad Input \nFeel Bad");
        if (banned >= 2) {
          System.out.println("Yeah I think were done here :( ");
          System.exit(0);
        }
      }
    }

  }
}
