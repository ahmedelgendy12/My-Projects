/*
 * Ahmed Elgendy
 * CS-152
 * Homework 3
 */

package HW3;

public class Novel extends Book {

  private String author;

  public Novel(String title, int year, String author) {
    super(title, year);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Title: " + title + " by " + author;
  }
}
