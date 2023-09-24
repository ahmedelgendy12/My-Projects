
/**
 * Box
 * Ahmed Elgendy
 * Homework 4
 */
public class Box {
    
    private double leftSide;
    private double rightSide;
    private double bottom;
    private double top;
    
    public Box(double leftside, double rightside, double top, double bottom) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.top = top;
        this.bottom = bottom;
    }
    
    public Box() {
        leftSide = rightSide = bottom = top = 0;
    }
    
    public void setRightSide(double newRightSide) {
        rightSide = newRightSide;
    }
    
    public void setLeftSide(double newLeftSide) {
        leftSide = newLeftSide;
    }
    
    public void setBottom(double newBottom) {
        bottom = newBottom;
    }
    
    public void setTop(double newTop) {
        top = newTop;
    }
    
    public double getLeftSide() {
        return leftSide;
    }
    
    public double getRightSide() {
        return rightSide;
    }
    
    public double getTop() {
        return top;
    }
    
    public double getBottom() {
        return bottom;
    }
    
    public boolean isClosed() {
        boolean topCheck = top < bottom + leftSide + rightSide;
        boolean bottomCheck = bottom < top + leftSide + rightSide;
        boolean rightCheck = rightSide < top + bottom + leftSide;
        boolean leftCheck = leftSide < top + bottom + rightSide;
        return (topCheck && bottomCheck && rightCheck && leftCheck);
    }
    
    public boolean isOpen() {
        boolean topCheck = top > bottom + leftSide + rightSide;
        boolean bottomCheck = bottom > top + leftSide + rightSide;
        boolean rightCheck = rightSide > top + bottom + leftSide;
        boolean leftCheck = leftSide > top + bottom + rightSide;
        return (topCheck || bottomCheck || rightCheck || leftCheck);
    }
    
    public boolean isSquare() {
        return (leftSide == rightSide 
        && bottom == top 
        && top == leftSide);
    }
    
    public boolean isRectangle() {
        return (bottom == top 
        && leftSide == rightSide 
        && leftSide != bottom);
    }
        
    
    public boolean isKite() {
        return ((leftSide == bottom && rightSide == top && leftSide != top) 
        || (leftSide == top && rightSide == bottom && rightSide != top));
    }
    
    public String toString(){
        String closed;
        String shape;
        
        if(isClosed()){
            closed = "Closed";
        } else {
            closed = "Open";
        }
        
        if(isSquare()){
            shape = "Square";
        } else if(isRectangle()){
            shape = "Rectangle";
        } else if(isKite()){
            shape = "Kite";
        } else {
            shape = "Crooked";
        }
        
        return leftSide + "-" + rightSide + "-" + top + "-" 
                + bottom + "\n" + closed + ",   " + shape;
    }
        
    public boolean equals(Box thatBox){
        if(leftSide == thatBox.getLeftSide() 
        && rightSide == thatBox.getRightSide()
        && bottom == thatBox.getBottom()
        && top == thatBox.getTop()
        || leftSide == thatBox.getRightSide()
        && rightSide == thatBox.getLeftSide()
        && bottom == thatBox.getTop()
        && top == thatBox.getBottom()){
            return true;
        } else {
            return false;
        }
    }

}
