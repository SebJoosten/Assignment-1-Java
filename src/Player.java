
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
       if(hand == null ||hand.isEmpty()){return 0;}

       // ******* Points tally here *****

       return 0;
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
