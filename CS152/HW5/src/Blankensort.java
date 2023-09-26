/*
 * @author Jeffrey Blankenship
 * 
 * (c) Copyright 2021, Jeffrey Blankenship, All rights reserved except as below:
 * 1. University students may use for academic purposes only.
 * 2. No license for commercial use.
 * 3. No distribution to 3rd parties without consent of the author.
 * 
 */


public class Blankensort {

  // constants for data generation
  private static final int UPPER_BOUND = 100;
  private static final int LENGTH = 50000000;

  // generate random linked list, [0,upperBound)
  // data is from 0 (inclusive) to upperBound (exclusive)
  private static Node random(int length, int upperBound) {
    System.out.print("Generating randoms");
    Node result = new Node();
    int ticker = length / 10;
    for (int count = 0; count < length; count++) {
      int data = (int) (Math.random() * upperBound);
      result.insert(data, 0);
      // add a ticker so user doesn't think it crashed
      if (count % ticker == 0) {
        System.out.print(".");
      }
    }
    System.out.println();
    return result;
  }

  public static void sort(Node input) throws InterruptedException {
    // O(n) create array of lists to hold all the nodes in order
    Node[] sublist = new Node[UPPER_BOUND];
    for (int index = 0; index < sublist.length; index++) {
      sublist[index] = new Node();
    }
    // O(n) transfer all nodes to appropriate sublist
    while (input.hasNext()) {
      Node temp = input.delete(0);
      sublist[temp.getData()].insert(temp, 0);
    }
    // O(n) transfer sorted nodes back to list
    for (int index = sublist.length - 1; index >= 0; index--) {
      // O(c) This is critical. Must not be O(n) or a nested loop
      // causes O(n^2) overall. The hasNext method CANNOT traverse the list.
      while (sublist[index].hasNext()) {
        input.insert(sublist[index].delete(0), 0);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {


    // initialize list with random numbers
    Node list = random(LENGTH, UPPER_BOUND);

    // Time the sort
    System.out.println("Starting sort");
    long startTime = System.currentTimeMillis();
    sort(list);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;

    // Display results
    System.out.println("Finished sort");
    System.out.printf("N = %,d\n", LENGTH);
    System.out.printf("Elapsed time: %,d msec\n", elapsedTime);

    // print the sorted list (but tends to lock the terminal up
    // if N is above 50,000 or so)
    // list.print();

  }

}
