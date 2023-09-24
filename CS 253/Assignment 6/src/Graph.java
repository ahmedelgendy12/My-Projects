// Ahmed Elgendy
// CS 253-01
// Assignment 6

class AdjList {

  public int value;
  public AdjList next;

  // Constructor
  public AdjList(int value) {
    this.value = value;
    this.next = null;
  }
}


class verNum {
  public int data;
  public AdjList next;
  public AdjList end;

  // Costructor
  public verNum(int data) {
    this.data = data;
    this.next = null;
    this.end = null;
  }
}


public class Graph {

  public int size;
  public verNum[] node;

  // Constructor
  public Graph(int size) {
    this.size = size;
    this.node = new verNum[size];
    this.setData();
  }

  public void setData() {
    for (int index = 0; index < size; index++) {
      node[index] = new verNum(index);
    }
  }

  // inserts an edge between two nodes
  public void insertEdge(int first, int last) {
    if (first >= 0 && first < size && last >= 0 && last < size) {
      connect(first, last);
      connect(last, first);
    }
  }

  // Connects two nodes together
  public void connect(int first, int last) {
    AdjList edge = new AdjList(last);
    if (node[first].next == null) {
      node[first].next = edge;
    } else {
      node[first].end.next = edge;
    }
    node[first].end = edge;
  }

  // prints the adjacency list
  public void print() {
    for (int index = 0; index < size; ++index) {
      System.out.print("\nVertex " + index + " :");
      AdjList temp = node[index].next;
      while (temp != null) {
        System.out.print("  " + node[temp.value].data);
        temp = temp.next;
      }
    }
  }



  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.insertEdge(0, 2);
    graph.insertEdge(2, 3);
    graph.insertEdge(2, 0);
    graph.insertEdge(1, 2);
    graph.insertEdge(0, 1);
    System.out.println("Adjacency List Structure");
    graph.print();
  }
}
