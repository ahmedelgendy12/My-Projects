/*
 * Ahmed Elgendy
 * CS-152
 * Homework 3
 */

package HW3;

public class Book implements Comparable<Book> {

  protected String title;
  private int year;

  public Book(String title, int year) {
    this.title = title;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return "Title: " + title;

  }

  // Compares Book by name and if the name is the same compares by year
  @Override
  public int compareTo(Book that) {
    int compare1 = this.title.compareToIgnoreCase(that.title);
    if (compare1 == 0) {
      if (this.year > that.year) {
        return 1;
      } else if (this.year < that.year) {
        return -1;
      } else {
        return 0;
      }
    } else {
      return compare1;
    }
  }
}
