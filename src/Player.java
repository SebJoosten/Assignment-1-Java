
/**
 * This is the player it holds the hands and calculates up the points to give to the dealer to congratulate the winner
 */
public class Player {
    private String name;
    private CardLinkedList hand;

    // ****** Constructor ******

    /**
     * Constructor for player
     * @param n The Name of this instance of player
     */
    public Player(String n) {
        name = n;
        hand = new CardLinkedList();
    }

    //****** Methods ******

    /**
     * Returns and resets this players hand
     * @return a CardLinkedList of all the cards this player had
     */
    public CardLinkedList returnHand() {

        CardLinkedList temp = hand;
        hand = new CardLinkedList();
        return temp;
    }

    /**
     *A method asking the player for the tally of their points
     * @return The number of points this player has from there hand
     */
    public int getPoints(){


        // Check hand is not empty
        if(hand == null || hand.isEmpty()){return 0;}

        // Set points to 0 and initialize processed list
        int points = 0;
        CardLinkedList processed = new CardLinkedList();

        System.out.println(" Comparing " );

        // For every card in the hand
        while(!hand.isEmpty()){


           // Take a card out of the hand
            CardLinkedList processing = new CardLinkedList();
            Card compare = hand.getCardAt(1);
            hand.remove(compare);
            processing.add(compare);



           // For every remaining card
           for(int j = hand.getLength(); j > 1 ; j--){
               System.out.println(" Comparing " );
               if(compare.equals(hand.getCardAt(j))){
                    Card c = hand.getCardAt(j);
                    hand.remove(c);
                    processing.add(c);
               }
           }



            int multiplayer = switch (processing.getLength()) {
                case 2 -> 10;
                case 3 -> 100;
                case 4 -> 1000;
                case 5 -> 10000;
                default -> 1;
            };

            points += multiplayer * (processing.getCardAt(1).getNumber() * processing.getLength() );

            // Move processed cards to the new list
            while (!processing.isEmpty()) {
                Card c = processing.getCardAt(1);
                processed.add(c);
                processing.remove(c);
                System.out.println(" Moving " );
            }

        }

        hand = processed;

        return points;
    }

    /**
     * Give a list of cards to the player
     * @param c CardLinkedList with cards for the player - Null input just returns
     */
    public void giveCards(CardLinkedList c) {
        if (c == null) { return; }
        hand = c;
    }

    /**
     * Prints out this players hand
     */
    public void print() {
        System.out.println("------ " + name + " ------");
        hand.print();
    }

}
