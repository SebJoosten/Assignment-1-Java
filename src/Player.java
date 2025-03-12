
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
    public long getPoints(){

        // Check hand is not empty
        if(hand == null || hand.isEmpty()){return 0;}

        // Set points to 0 and initialize processed list
        long points = 0;
        CardLinkedList processed = new CardLinkedList();

        // For every card in the hand
        while(!hand.isEmpty()){

            // Take a card out of the hand
            CardLinkedList processing = new CardLinkedList();
            Card compare = hand.getCardAt(1);
            hand.remove(compare);
            processing.add(compare);

            // For every remaining card
            for(int j = hand.getLength(); j > 0 ; j--){
                if(compare.equals(hand.getCardAt(j))){
                    Card c = hand.getCardAt(j);
                    hand.remove(c);
                    processing.add(c);
                }
            }

            // Set the multiplier
            long multiplayer = 1;
            for(int i = 1; i < processing.getLength(); i++){
                multiplayer *= 10;
            }

            // Calculate points
            points += multiplayer * ((long)processing.getCardAt(1).getNumber() * processing.getLength() );

            // Move processed cards to the new list
            while (!processing.isEmpty()) {
                Card c = processing.getCardAt(1);
                processed.add(c);
                processing.remove(c);
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
