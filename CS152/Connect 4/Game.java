/* @author Jeff Blankenship
 * CS-151
 * Central Connecticut State University
 * 
 * @license This code may not be used for any commercial use.  Academic use
 * is allowed by the author's students.  No other use is authorized 
 * without permission.
 * 
 * This code is derivitive work based on the Connect 4 game by Hasbro.
 * Game class provides the graphics for a game, without any of the 
 * backend game control. 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class Game extends JPanel {
  
  //Constants used for the spacing and size of the gamespace components
  private final int  SEPARATION = 30; //px between game spots, and to edge
  private final int  DIAMETER = 60;  //diameter of games circles
  
  //define the CCSU logo color with RGB values
  final Color CCSU_BLUE = new Color(26, 71, 132);
  
  // instance variables
  private 
  int gameSize = (5 * DIAMETER) + (6 * SEPARATION);
  //grid for the game.
  // 0:black  (player)1:blue  (player)2:red
  private static int[][] grid = 
    {
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
    };

  public Game() throws InterruptedException {
    JFrame frame = new JFrame("CS-151 Four In A Row");
    frame.add(this);
    frame.setSize(gameSize+SEPARATION, gameSize+SEPARATION);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }  
    
  //sets the specified element of the grid array to
  //the given value, which will in turn change the color
  public void setSpot(int x, int y, int value){
    grid[x][y] = value;  
    this.repaint();
  }
  
  //sets the entire grid[][] to the pass parameter
  public void setGrid(int[][] newGrid){
    this.grid = newGrid.clone();
    this.repaint();
  }
    
  
  public
  void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
    
    //set up a canvas to paint on
    Graphics2D g2 = (Graphics2D) g;  
    
    //add the yellow background
    g2.setColor(Color.yellow);
    gameSize = (5 * DIAMETER) + (6 * SEPARATION);
    Rectangle rect1 = new Rectangle(0,0,gameSize,gameSize); //x,y,width,height
    g2.fill(rect1);
    
    //fill in the game positions with circles
    //of the appropriate color
    for (int col=0; col<5; col++){
      for (int row=0; row<5; row++){
        //assign color per grid
        if (grid[col][row]==0) {
          g2.setColor(Color.lightGray);
        }else if (grid[col][row]==1) {
          g2.setColor(Color.blue);
        }else if (grid[col][row]==2) {
          g2.setColor(Color.red);
        }else {
          //should never get here
          System.out.println("Error in grid value.  0,1,2 are acceptable.");
        }
        //calculate the position 
        int xPosit = (DIAMETER/2) + col * (SEPARATION+DIAMETER);
        int yPosit = (DIAMETER/2) + row * (SEPARATION+DIAMETER);        
        //construct the circle
        Ellipse2D.Double ellipse = new Ellipse2D.Double(xPosit,yPosit,DIAMETER,DIAMETER);
        g2.fill(ellipse);
      } //for (int row=0
    }//for (int col=0
  }
  
  private static void redraw(Game game){
    game.repaint(); 
  }
  
  

}