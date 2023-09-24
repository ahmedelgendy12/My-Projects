// Ahmed Elgendy
// CS 253-01
// Assignment 6

public class Graph {
  Integer[][] adjMat;
  int numVer;

  // Constructor
  public Graph(int numVer) {
    this.numVer = numVer;
    adjMat = new Integer[numVer][numVer];
  }

  // removes edge by setting it to 0 in the 2d array
  public void removeEdge(int x, int y) {
    adjMat[x][y] = 0;
    adjMat[y][x] = 0;
  }

  // inserts edge by setting it to 1 in the 2d array
  public void insertEdge(int x, int y) {
    adjMat[x][y] = 1;
    adjMat[y][x] = 1;
  }

  // Prints the matrix as a table of 1s and 0s.
  public void print() {
    for (int i = 0; i < numVer; i++) {
      System.out.print("   " + i);
    }
    System.out.println();
    for (int i = 0; i < numVer; i++) {
      System.out.print(i + "| ");
      for (int j = 0; adjMat.length > j; j++) {
        if (adjMat[i][j] == null) {
          adjMat[i][j] = 0;
        }
        System.out.print(adjMat[i][j] + ",  ");
      }
      System.out.println();
    }
  }

  // Test Harness
  public static void main(String args[]) {
    Graph graph = new Graph(4);
    graph.insertEdge(0, 2);
    graph.insertEdge(2, 3);
    graph.insertEdge(2, 0);
    graph.insertEdge(1, 2);
    graph.insertEdge(0, 1);
    System.out.println("Adjacency Matrix Structure");
    graph.print();
  }
}


