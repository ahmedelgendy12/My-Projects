//Ahmed Elgendy
//CS-152
//Problem 3: Don't Mess With Texas

public class Texas {

    public static int CALIFORNIA = 32000000;
    public static int TEXAS = 25000000;

    public static void main(String[] args) {
        boolean equalOrGreater = false;
        int years = 0;

        while (!equalOrGreater) {
            CALIFORNIA *= .98;
            TEXAS *= 1.03;

            if (TEXAS > CALIFORNIA) {
                equalOrGreater = true;
            }

            ++years;
        }

        System.out.println("It took " + years + " years for the population of Texas to surpass California!");
    }
}
