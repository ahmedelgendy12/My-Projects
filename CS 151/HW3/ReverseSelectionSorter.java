/*
 * Ahmed Elgendy
 * CS-152
 * Homework 3
 */
package HW3;

import java.util.Arrays;

public class ReverseSelectionSorter {

  public static void reverseSelectionSort(Object[] list) {


    Book[] bookArray = new Book[4];
    Integer[] intArray = new Integer[3];
    // Checks if in input is and Integer Array or a Book Array
    if (list.getClass() == bookArray.getClass()) {

      bookArray = (Book[]) list;
      // Compares each element to the other and finds the maxIndex
      int maxIndex = 0;
      for (int index = bookArray.length - 1; index >= 0; index--) {
        // find maximum element

        if (bookArray[maxIndex].compareTo(bookArray[index]) < 0) {
          maxIndex = index;
        }
        System.out.println("Current Array: " + Arrays.toString(list) + "\n");
        // swaps index with the maxIndex
        Object temp = list[index];
        list[index] = list[maxIndex];
        list[maxIndex] = temp;
      }

    } else if (list.getClass() == intArray.getClass()) {
      intArray = (Integer[]) list;



      // iterate unsorted through array
      for (int unsorted = 0; unsorted < intArray.length; unsorted++) {
        // find maximum element
        int minIndex = unsorted;
        for (int index2 = unsorted; index2 < intArray.length; index2++) {
          if (intArray[index2] < intArray[minIndex]) {
            minIndex = index2;
          }
          System.out.println("Current Array: " + Arrays.toString(list) + "\n");
        }
        // swap firstUnsorted with max element
        Object temp = list[unsorted];
        list[unsorted] = list[minIndex];
        list[minIndex] = temp;
      }

    } else {
      // do nothing
    }
  }
}


