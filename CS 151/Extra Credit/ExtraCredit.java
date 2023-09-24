//Ahmed Elgendy
//CS-151
//Extra Credit

import java.util.Scanner;

public class ExtraCredit {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String passColor;
        String lotColor;
        String status;
        boolean park = true;
        boolean reserved = false;

        System.out.println("Are you faculty, commuting student, or a resident student?");
        status = scan.nextLine();

        System.out.println("What is your pass color?");
        passColor = scan.nextLine();

        System.out.println("What is your lot color?");
        lotColor = scan.nextLine();

        while(!reserved) {
            System.out.println("is the spot reserved?");
            String reservedThat = scan.nextLine();

            if (reservedThat.equalsIgnoreCase("yes") || reservedThat.equalsIgnoreCase("no")) {
                if (reservedThat.equalsIgnoreCase("yes")) {
                    park = reserved = true;
                } else {
                    reserved = true;
                }
            } else {
                System.out.println("You must enter yes or no!");
            }
        }

        if (status.equalsIgnoreCase("faculty")
                && park
                && passColor.equalsIgnoreCase("yellow")
                && lotColor.equalsIgnoreCase("yellow")){

            System.out.println("yeah you can park there.");

        } else if (status.equalsIgnoreCase("commuting student")
                && park
                && passColor.equalsIgnoreCase("red")
                && lotColor.equalsIgnoreCase("red")){

            System.out.println("yes of course you can park there.");
        } else if (status.equalsIgnoreCase("resident student")
                && passColor.equalsIgnoreCase("green")
                && park
                && lotColor.equalsIgnoreCase("green")){

            System.out.println("yay you can park here :)");
        } else {
            System.out.println("you cannot park here :(");
        }
    }
}