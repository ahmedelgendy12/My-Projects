package HW3;

import java.util.Arrays;

public class HW3Demo {
  public static void main(String[] args) {
    Integer[] numbers = {4, 2, 9, 1, 8};
    ReverseSelectionSorter.reverseSelectionSort(numbers);
    System.out.println(Arrays.toString(numbers) + "\n\n");

    Book book = new Book("Zanny Java Programming", 2017);
    Novel novel1 = new Novel("Joyland", 2005, "Emily Schultz");
    Novel novel2 = new Novel("Joyland", 2013, "Stephen King");
    Dictionary dict = new Dictionary("Webster's Dictionary", 2021, 470000);
    System.out.println(book + "\n");
    System.out.println(novel1 + "\n");
    System.out.println(novel2 + "\n");
    System.out.println(dict + "\n");

    Book[] books = {book, novel1, novel2, dict};
    ReverseSelectionSorter.reverseSelectionSort(books);
    System.out.println("\n\n" + Arrays.toString(books));
  }
}
