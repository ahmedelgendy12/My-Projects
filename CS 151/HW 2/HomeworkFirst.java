import java.util.Scanner;

public class HomeworkFirst {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String homeworkDone;
        boolean validTemperature = false;
        int temperature = 0;

        while (!validTemperature) {
            print("What is the temperature outside?");

            temperature = scan.nextInt();
            validTemperature = temperature < 120 && temperature > -100;

            if (!validTemperature) {
                print("Temperature must be from -100 to 120 inclusive ");
            }
        }

        boolean done = false;

        while (!done) {
            print("Is your homework done?");
            homeworkDone = scan.nextLine();
            homeworkDone = scan.nextLine();
            done = homeworkDone.equalsIgnoreCase("yes") || homeworkDone.equalsIgnoreCase("no");

            if (done) {
                if (homeworkDone.equalsIgnoreCase("yes")) {
                    if (temperature > 70) {
                        print("Go play outside!");
                    } else {
                        print("Go read a book!");
                    }
                } else {
                    print("Get to work!");
                }
            } else {
                print("Acceptable answers are yes, Yes, no, No.");
            }
        }
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
 