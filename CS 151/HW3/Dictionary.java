/*
 * Ahmed Elgendy
 * CS-152
 * Homework 3
 */

package HW3;

public class Dictionary extends Book {

  private int numWords;

  public Dictionary(String title, int year, int numWords) {
    super(title, year);
    this.numWords = numWords;
  }

  public int getNumWords() {
    return numWords;
  }

  @Override
  public String toString() {
    return "Title: " + title + " definitions of " + numWords + " words";

  }
}
