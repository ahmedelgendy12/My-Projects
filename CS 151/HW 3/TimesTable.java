//Ahmed Elgendy
//CS-152
//Problem 1: Times Table

public class TimesTable {
  
  public static void main(String[] args){

    final int TOTAL_ROW = 47;
    final int TOTAL_COLUMN = 14;
    
    for(int row = 1; row < TOTAL_ROW; row = row + 5){
      
      for(int col = 1; col < TOTAL_COLUMN; col = col + 3){
        System.out.printf("%5d    ",row * col);
      }
      System.out.println("");
    }
  }
}  