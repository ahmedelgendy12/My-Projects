/* @author Jeff Blankenship
 * 
 * Implementing this interface will provide you with data generation
 * tools for use in search and sort algorithm testing. It provides
 * random or ordered integers in either arrays or arrayLists.
 */

import java.util.ArrayList;

public interface ListInterface {

  /*
   * returns an array of random integers of the length indicated.
   * Elements range from 0(inclusive) to upperBoud(exclusive)
   */
  public int[] getRandomArray(int length, int upperBound);

  /*
   * returns an array of ordered integers of the length indicated.
   * Elements start at 0 and increase by increment.
   */
  public int[] getOrderedArray(int length, int increment);

  /*
   * returns an ArrayList of random integers of the length indicated.
   * Elements range from 0(inclusive) to upperBoud(exclusive)
   */
  public ArrayList<Integer> getRandomArrayList(int length, int upperBound);

  /*
   * returns an ArrayList of ordered integers of the length indicated.
   * Elements start at 0 and increase by increment.
   */
  public ArrayList<Integer> getOrderedArrayList(int length, int increment);
  
  /*
   * String representation of an array with elements separated by spaces.
   */
  public String toString(int[] array);
  
  /*
   * String representation of an ArrayList with elements separated by spaces.
   */
  public String toString(ArrayList<Integer> arrayList);

}

