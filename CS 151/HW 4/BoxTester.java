/**
 * BoxTester
 * Ahmed Elgendy
 * Homework 4
 */

import java.util.Scanner;

public class BoxTester {

    public static void main(String[] args) {
        Box box1 = new Box();

        Scanner scan = new Scanner(System.in);

        System.out.println("For box one:");
        System.out.print("Enter the left side length:");
        box1.setLeftSide(scan.nextDouble());

        System.out.print("Enter the right side length:");
        box1.setRightSide(scan.nextDouble());

        System.out.print("Enter the top length:");
        box1.setTop(scan.nextDouble());

        System.out.print("Enter the bottom length:");
        box1.setBottom(scan.nextDouble());

        Box box2 = new Box();

        System.out.println(" ");
        System.out.println("For box two:");
        System.out.print("Enter the left side length:");
        box2.setLeftSide(scan.nextDouble());

        System.out.print("Enter the right side length:");
        box2.setRightSide(scan.nextDouble());

        System.out.print("Enter the top length:");
        box2.setTop(scan.nextDouble());

        System.out.print("Enter the bottom length:");
        box2.setBottom(scan.nextDouble());

        System.out.println(" ");
        System.out.println("box1: " + box1.toString());
        System.out.println(" ");
        System.out.println("box2: " + box2.toString());
        System.out.println("box1 and box2 are equal: " + box1.equals(box2));
    }
}
