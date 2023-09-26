import java.util.Random;

public class SearchAndSort {

  public static int binarySearch(long[] array, int target) throws InterruptedException {
    long startTime = System.nanoTime();

    int end = array.length - 1;
    int begin = 0;
    int targetIndex = 0;
    int middle = (end + begin) / 2;
    // get the middle of the array and keep finding the middle till middle = target.
    while (middle > begin) {
      Thread.sleep(1);
      if (array[middle] == target) {
        targetIndex = middle;
      } else if (array[middle] < target) {
        begin = middle;
        middle = (begin + end) / 2;
      } else {
        end = middle;
        middle = (begin + end) / 2;
      }
    }

    long endTime = System.nanoTime();
    float totalSeconds = (float) (endTime - startTime);; // 1000000;
    System.out.println("Total time for Binary Search: " + totalSeconds + " nanoseconds");

    return targetIndex;
  }

  public static int linearSearch(long[] array, int target) {
    long startTime = System.nanoTime();

    int targetIndex = 0;
    // iterate through the array

    for (int index = 0; index < array.length; index++) {
      // get target

      if (array[index] == index) {
        targetIndex = index;

      }
    }

    long endTime = System.nanoTime();
    float totalSeconds = (float) (endTime - startTime) / 1000000;
    System.out.println("Total time for Linear Search: " + totalSeconds + " milliseconds");

    return targetIndex;
  }

  public static void bubbleSort(long[] array) {
    long startTime = System.nanoTime();

    // repeat outer loop N times
    for (int outer = 0; outer < array.length; outer++) {
      // iterate through and swap out of order array
      for (int inner = 0; inner < array.length - 1; inner++) {
        if (array[inner] > array[inner + 1]) {
          long temp = array[inner];
          array[inner] = array[inner + 1];
          array[inner + 1] = temp;
        }

      }
    }
    long endTime = System.nanoTime();
    float totalSeconds = (float) (endTime - startTime) / 1000000;
    System.out.println("Total time for Bubble Sort Search: " + totalSeconds + " milliseconds");
  }

  public static long[] random(long[] array, int range) {
    Random random = new Random();
    for (int index = 0; index < array.length; index++) {
      array[index] = random.nextInt(range);
    }
    return array;

  }

  public static long[] sorted(long[] array) {
    for (int index = 0; index < array.length; index++) {
      if (index != 3000) {
        array[index] = index;
      } else {
        array[index] = 2999;
      }
    }
    /*
     * if (array.length < 10000) {
     * array[index] = index;
     * } else {
     * array[index] = 10100;
     * }
     * }
     */
    return array;
  }
}
