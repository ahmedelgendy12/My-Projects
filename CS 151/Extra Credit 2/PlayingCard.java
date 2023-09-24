/**
 * Ahmed Elgendy
 * Homework 5
 * part 2
 */
import java.util.Random;

public class PlayingCard {
    private int rank;
    private String suit;
    private Random rand = new Random();

    public PlayingCard()
    {
        rank = rand.nextInt(13) + 1;

        int temp =  rand.nextInt(4);
        if(temp == 0){
            suit = "Hearts";
        } 

        if(temp == 1){
            suit = "Diamonds";
        } 
        if(temp == 2){
            suit = "Clubs";
        } 
        if(temp == 3){
            suit = "Spayeds";
        } 
    }

    public int getRank(){
        return rank;

    }

    public String getSuit(){
        return suit;
    }

    public String toString(){
        if ( rank == 1 || rank == 11 || rank == 12 || rank == 13){
            String face = " ";
            if (rank == 1){
                face = "Ace";
            }
            if (rank == 11){
                face = "Jack";
            }
            if (rank == 12){
                face = "Queen";
            }
            if (rank == 13){
                face = "King";
            }
            return (face + " of " + suit);
        } else {
            return (rank + " of " + suit);
        }
    }
}
