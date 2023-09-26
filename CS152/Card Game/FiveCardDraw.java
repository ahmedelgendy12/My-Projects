/**
 * Ahmed Elgendy
 * Homework 5
 * Part 3
 */
import java.util.Scanner;

public class FiveCardDraw {
    public static void main(String[] args){
        boolean change = true;
        int i = 3;

        Scanner scan = new Scanner(System.in);

        PlayingCard card1 = new PlayingCard();
        PlayingCard card2 = new PlayingCard();
        PlayingCard card3 = new PlayingCard();
        PlayingCard card4 = new PlayingCard();
        PlayingCard card5 = new PlayingCard();

        if ((card1.getRank() == card2.getRank() &&  card1.getSuit().equals(card2.getSuit()))
        || (card1.getRank() == card3.getRank() && card1.getSuit().equals(card3.getSuit()))
        || (card1.getRank() == card4.getRank() &&  card1.getSuit().equals(card4.getSuit()))
        || (card1.getRank() == card5.getRank() &&  card1.getSuit().equals(card5.getSuit()))){
            card1 = new PlayingCard();
        }

        if ((card2.getRank() == card3.getRank()) &&  (card2.getSuit().equals(card3.getSuit()))
        || (card2.getRank() == card4.getRank() &&  (card2.getSuit().equals(card4.getSuit()))
            || (card2.getRank() == card5.getRank() &&  (card2.getSuit().equals(card5.getSuit()))))){
            card2 = new PlayingCard();
        }

        if ((card3.getRank() == card4.getRank() &&  (card3.getSuit().equals(card4.getSuit()))
            || (card3.getRank() == card5.getRank() &&  (card3.getSuit().equals(card5.getSuit()))))){
            card3 = new PlayingCard();

        }   

        if ((card4.getRank() == card5.getRank() &&  (card4.getSuit().equals(card5.getSuit())))){
            card4 = new PlayingCard();
        }

        while(change){
            
            for(int z = 0; z <= 22; z++){
                System.out.println(" ");
            }
            
            System.out.println("The Current hand is:");
            System.out.println("Card 1: " + card1.toString());
            System.out.println("Card 2: " + card2.toString());
            System.out.println("Card 3: " + card3.toString());
            System.out.println("Card 4: " + card4.toString());
            System.out.println("Card 5: " + card5.toString());

            if((card1.getRank() == 10 && card2.getRank() == 11 && card3.getRank() == 12 && card4.getRank() == 13 && card5.getRank() == 1
                || card2.getRank() == 10 && card3.getRank() == 11 && card4.getRank() == 12 && card5.getRank() == 13 && card1.getRank() == 1
                || card3.getRank() == 10 && card4.getRank() == 11 && card5.getRank() == 12 && card1.getRank() == 13 && card2.getRank() == 1
                || card4.getRank() == 10 && card5.getRank() == 11 && card1.getRank() == 12 && card2.getRank() == 13 && card3.getRank() == 1
                || card5.getRank() == 10 && card1.getRank() == 11 && card2.getRank() == 12 && card3.getRank() == 13 && card4.getRank() == 1)
            && (card1.getSuit().equals(card2.getSuit()) && card1.getSuit().equals(card3.getSuit()) && card1.getSuit().equals(card4.getSuit()) && card1.getSuit().equals(card5.getSuit()))){
                System.out.println("Hand rank is Royal Flush");
            }else if((card1.getRank() == card2.getRank() + 1 && card1.getRank() == card3.getRank() + 2 && card1.getRank() == card4.getRank() + 3 && card1.getRank() == card5.getRank() + 4
                || card1.getRank() == card3.getRank() + 1 && card1.getRank() == card4.getRank() + 2 && card1.getRank() == card5.getRank() + 3 && card1.getRank() == card2.getRank() + 4
                || card1.getRank() == card4.getRank() + 1 && card1.getRank() == card5.getRank() + 2 && card1.getRank() == card2.getRank() + 3 && card1.getRank() == card3.getRank() + 4
                || card1.getRank() == card5.getRank() + 1 && card1.getRank() == card2.getRank() + 2 && card1.getRank() == card3.getRank() + 3 && card1.getRank() == card4.getRank() + 4)
            && (card1.getSuit().equals(card2.getSuit()) && card1.getSuit().equals(card3.getSuit()) && card1.getSuit().equals(card4.getSuit()) && card1.getSuit().equals(card5.getSuit()))){
                System.out.println("Hand rank is Straight Flush");
            } else if (card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank() && card1.getRank() == card4.getRank()
            ||card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank() && card1.getRank() == card5.getRank()
            ||card1.getRank() == card2.getRank() && card1.getRank() == card4.getRank() && card1.getRank() == card5.getRank()
            ||card1.getRank() == card3.getRank() && card1.getRank() == card4.getRank() && card1.getRank() == card5.getRank()
            ||card2.getRank() == card3.getRank() && card2.getRank() == card4.getRank() && card1.getRank() == card5.getRank()){
                System.out.println("Hand rank is Four of a Kind");
            } else if ((((card1.getRank() != card2.getRank() || card1.getRank() != card3.getRank()) || (card4.getRank() != card5.getRank()))
                && ((card1.getRank() != card2.getRank() || card1.getRank() != card3.getRank()) || (card4.getRank() != card5.getRank()))
                && ((card1.getRank() != card3.getRank() || card1.getRank() != card4.getRank()) || (card2.getRank() != card5.getRank()))
                && ((card1.getRank() != card4.getRank() || card1.getRank() != card5.getRank()) || (card2.getRank() != card3.getRank()))
                && ((card1.getRank() != card5.getRank() || card1.getRank() != card2.getRank()) || (card3.getRank() != card4.getRank()))
                && ((card2.getRank() != card4.getRank() || card2.getRank() != card3.getRank()) || (card1.getRank() != card5.getRank()))
                && ((card2.getRank() != card5.getRank() || card2.getRank() != card3.getRank()) || (card4.getRank() != card1.getRank()))
                && ((card2.getRank() != card3.getRank() || card2.getRank() != card4.getRank()) || (card1.getRank() != card5.getRank()))
                && ((card2.getRank() != card4.getRank() || card2.getRank() != card5.getRank()) || (card1.getRank() != card3.getRank()))
                && ((card2.getRank() != card5.getRank() || card2.getRank() != card3.getRank()) || (card1.getRank() != card4.getRank()))
                && ((card3.getRank() != card4.getRank() || card3.getRank() != card5.getRank()) || (card1.getRank() != card2.getRank())))) {
                if (card1.getSuit().equals(card2.getSuit()) && card1.getSuit().equals(card3.getSuit()) && card1.getSuit().equals(card4.getSuit()) && card1.getSuit().equals(card5.getSuit())){
                    System.out.println("Hand rank is Flush");
                } else if (((card1.getRank() == card2.getRank() + 1 && card1.getRank() == card3.getRank() + 2 && card1.getRank() == card4.getRank() + 3 && card1.getRank() == card5.getRank() + 4
                        || card1.getRank() == card3.getRank() + 1 && card1.getRank() == card4.getRank() + 2 && card1.getRank() == card5.getRank() + 3 && card1.getRank() == card2.getRank() + 4
                        || card1.getRank() == card4.getRank() + 1 && card1.getRank() == card5.getRank() + 2 && card1.getRank() == card2.getRank() + 3 && card1.getRank() == card3.getRank() + 4
                        || card1.getRank() == card5.getRank() + 1 && card1.getRank() == card2.getRank() + 2 && card1.getRank() == card3.getRank() + 3 && card1.getRank() == card4.getRank() + 4))){
                    System.out.println("Hand rank is Straight");
                } else if (((card1.getRank() != card2.getRank() || card1.getRank() != card3.getRank())
                    && (card1.getRank() != card2.getRank() || card1.getRank() != card3.getRank())
                    && (card1.getRank() != card3.getRank() || card1.getRank() != card4.getRank())
                    && (card1.getRank() != card4.getRank() || card1.getRank() != card5.getRank())
                    && (card1.getRank() != card5.getRank() || card1.getRank() != card2.getRank())
                    && (card2.getRank() != card4.getRank() || card2.getRank() != card3.getRank())
                    && (card2.getRank() != card5.getRank() || card2.getRank() != card3.getRank())
                    && (card2.getRank() != card3.getRank() || card2.getRank() != card4.getRank())
                    && (card2.getRank() != card4.getRank() || card2.getRank() != card5.getRank())
                    && (card2.getRank() != card5.getRank() || card2.getRank() != card3.getRank())
                    && (card3.getRank() != card4.getRank() || card3.getRank() != card5.getRank()))) {
                    if (((card1.getRank() == card2.getRank() && card3.getRank() == card4.getRank()
                            || (card1.getRank() == card2.getRank()) && (card3.getRank() == card4.getRank())
                            || (card1.getRank() == card3.getRank()) && (card2.getRank() == card4.getRank())
                            || (card1.getRank() == card4.getRank()) && (card5.getRank() == card4.getRank())
                            || (card1.getRank() == card5.getRank()) && (card3.getRank() == card4.getRank())
                            || (card2.getRank() == card3.getRank()) && (card5.getRank() == card4.getRank())
                            || (card2.getRank() == card4.getRank()) && (card3.getRank() == card5.getRank())
                            || (card2.getRank() == card5.getRank()) && (card3.getRank() == card4.getRank())
                            || (card2.getRank() == card5.getRank()) && (card1.getRank() == card4.getRank())
                            || (card3.getRank() == card4.getRank()) && (card1.getRank() == card5.getRank())
                            || (card3.getRank() == card5.getRank()) && (card1.getRank() == card2.getRank())))){
                        System.out.println("Hand rank is Two pair");
                    } else if ( ((card1.getRank() == card2.getRank())
                        || (card1.getRank() == card2.getRank())
                        || (card1.getRank() == card3.getRank())
                        || (card1.getRank() == card4.getRank())
                        || (card1.getRank() == card5.getRank())
                        || (card2.getRank() == card3.getRank())
                        || (card2.getRank() == card4.getRank())
                        || (card2.getRank() == card5.getRank())
                        || (card2.getRank() == card5.getRank())
                        || (card3.getRank() == card4.getRank())
                        || (card3.getRank() == card5.getRank()))){
                        System.out.println("Hand rank is Pair");
                    } else if ( card1.getRank() == 1 || card2.getRank() == 1 || card3.getRank() == 1 || card4.getRank() == 1 || card5.getRank() == 1){
                        System.out.println("Hand rank is Ace high");
                    } else if (card1.getRank() == 11 || card2.getRank() == 11 || card3.getRank() == 11 || card4.getRank() == 1 || card5.getRank() == 11){
                        System.out.println("Hand rank is Jack high");
                    } else if ( card1.getRank() == 12 || card2.getRank() == 12 || card3.getRank() == 12 || card4.getRank() == 12 || card5.getRank() == 12){
                        System.out.println("Hand rank is Queen high");
                    } else if ( card1.getRank() == 13 || card2.getRank() == 13 || card3.getRank() == 13 || card4.getRank() == 13 || card5.getRank() == 13){
                        System.out.println("Hand rank is King high");
                    }
                } else {
                    System.out.println("Hand rank is Three of a Kind");
                }
            } else {
                System.out.println("Hand rank is Full House");
            }

            System.out.println("You have " + i + " discard remaining");
            System.out.print("# of card to discard, or 6 to continue: ");
            int exchange = scan.nextInt();

            switch (exchange){
                case 1:
                card1 = new PlayingCard();
                i--;
                if (i <= -1 && i > -3){
                    change = false; 
                }
                break;
                case 2:
                card2 = new PlayingCard();
                i--;
                if (i <= -1 && i > -3){
                    change = false; 
                }
                break;
                case 3:
                card3 = new PlayingCard();
                i--;
                if (i <= -1 && i > -3){
                    change = false; 
                }
                break;
                case 4:
                card4 = new PlayingCard();
                i--;
                if (i <= -1 && i > -3){
                    change = false; 
                }
                break;
                case 5:
                card5 = new PlayingCard();
                i--;
                if (i <= -1 && i > -3){
                    change = false; 
                }
                break;
                case 6: 
                i = -1;
                change = false; 
                break;

            }
        }
        System.out.println("That is your cards :)");
    }
}

