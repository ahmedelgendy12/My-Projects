import java.util.*;
public class Overflow {
  public static void main(String[] args) {
  
    Scanner scan = new Scanner(System.in);
    String s1 = getString(scan);
    char[] vals = new char[s1.length()];
    copyVals(s1,vals);

    String sub = getSubstring(scan,vals);
    System.out.println("sub string: "+sub);
  }

  public static String getString(Scanner scan) {
    System.out.print("Please type a string: ");
    String s = scan.nextLine();
    return s;
  }

  public static void copyVals(String s,char[] vals) {
    for (int i = 0; i < s.length(); i++) {
      vals[i] = s.charAt(i);
    }
  }

  public static String getSubstring(Scanner scan,char[] vals) {
    System.out.print("Starting point: ");
    int start = scan.nextInt();
    System.out.print("Ending point: ");
    int end = scan.nextInt();
    if(end > vals.length) {
	end = vals.length;
    }
    char[] newChars = getChars(start,end,vals);
    return new String(newChars);
   }
public static char[] getChars(int start,int end,char[] vals) {

    int sz = end-start;
    char[] result = new char[sz];
    for (int i=0; i < sz; i++){
        result[i] = vals[start+i];
    }
    return result;
  }
}