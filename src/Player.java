/**
 * This is the player it holds the hands and calculates up the points to give to the dealer to congratulate the winner
 */

public class Player {
    private String name;
    private CardLinkedList hand;

    /**
     * Constructor for player
     * @param n The Name of this instance of player
     *
     */
    public Player(String n) {
        name = n;
        hand = new CardLinkedList();
    }

    /**
     * Simple method to return the cards given to the player and re fresh the players hand
     * @return a CardLinkedList of all the cards this player has
     */
    public CardLinkedList returnHand() {
        if (hand == null || hand.isEmpty()) {
            return null;
        }

        CardLinkedList temp = hand;
        hand = null;
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
     * @param c The CardLinkedList with the cards in it
     */
    public void giveCards(CardLinkedList c) {
        if (c == null) { return; }
        hand = c;
    }

    /**
     * Simple print method to print this hand
     */
    public void print() {
        System.out.println(name);
        hand.print();
    }

}
