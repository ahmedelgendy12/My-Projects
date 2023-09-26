public class driver {
  public static void main(String[] args) throws InterruptedException {
    long[] array = new long[5000000];
    long[] array2 = new long[15000000];
    long[] array3 = new long[30000000];
    long[] array4 = new long[80000000];
    long[] array5 = new long[50000];

    // get a sorted array already so it doesn't take long to do binary

    // Timing set #1
    System.out.println("First array test run:");
    // array = SearchAndSort.random(array, 1000);
    // SearchAndSort.linearSearch(array, 98999899);
    // SearchAndSort.bubbleSort(array);

    // array = SearchAndSort.sorted(array);
    // SearchAndSort.binarySearch(array, 3000);

    // Timing set #2
    System.out.println("\n\n\nSecond array test run:");
    // array2 = SearchAndSort.random(array2, 1000);
    // SearchAndSort.linearSearch(array2, 989898999);
    // SearchAndSort.bubbleSort(array2);

    // array2 = SearchAndSort.sorted(array2);
    // SearchAndSort.binarySearch(array2, 3000);

    // Timing set #3
    System.out.println("\n\n\nThird array test run:");
    // array = SearchAndSort.random(array3, 1000);
    // SearchAndSort.linearSearch(array3, 989898999);
    // SearchAndSort.bubbleSort(array3);

    // array3 = SearchAndSort.sorted(array3);
    // SearchAndSort.binarySearch(array3, 3000);

    // Timing set #4
    System.out.println("\n\n\nFourth array test run:");
    // array = SearchAndSort.random(array4, 1000);
    // SearchAndSort.linearSearch(array4, 989898999);
    // SearchAndSort.bubbleSort(array4);

    // array4 = SearchAndSort.sorted(array4);
    // SearchAndSort.binarySearch(array4, 3000);

    // Timing set #5
    System.out.println("\n\n\nFifth array test run:");
    // array = SearchAndSort.random(array5, 1000);
    // SearchAndSort.linearSearch(array5, 989898999);
    // SearchAndSort.bubbleSort(array5);

    array5 = SearchAndSort.sorted(array5);

    long start = System.currentTimeMillis();
    SearchAndSort.binarySearch(array5, 3000);
    long end = System.currentTimeMillis();
    long elapsed = end - start;
    System.out.println("hey there this is millis:  " + elapsed);

  }
}
