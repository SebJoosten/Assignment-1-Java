/**
 * This is the player it
 * - holds the hands
 * - calculates this players points based on the hand
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
     * Otherwise an empty list
     */
    public CardLinkedList returnHand() {

        // Check for empty hand
        if (hand == null) {
            hand = new CardLinkedList(); // Ensure hand is always initialized
            return new CardLinkedList(); // Return an empty list if hand was null
        }

        CardLinkedList temp = hand.isEmpty() ? new CardLinkedList() : hand;
        hand = new CardLinkedList();
        return temp;
    }

    /**
     *A method asking the player for the tally of their points
     * @return The number of points this player has from there hand
     */
    public long getPoints() {
        // Check hand is not empty
        if (hand == null || hand.isEmpty()) {
            return 0;
        }

        // Set points to 0 and make a copy of the hand
        long points = 0;
        CardLinkedList handCopy = hand.getCopy();

        // For every card in the handCopy
        while (!handCopy.isEmpty()) {

            // Take a card out of the handCopy
            CardLinkedList processing = new CardLinkedList();
            Card compare = handCopy.getCardAt(0);
            handCopy.remove(compare);
            processing.add(compare);

            // For every remaining card Look for doubles
            for (int j = handCopy.getLength() - 1; j >= 0; j--) {
                if (compare.getNumber() == handCopy.getCardAt(j).getNumber()) {
                    Card c = handCopy.getCardAt(j);
                    handCopy.remove(c);
                    processing.add(c);
                }
            }

            // Set the multiplier based on number of copies
            long multiplier = 1;
            for (int i = processing.getLength(); i > 1; i--) {
                multiplier *= 10;
            }

            // Calculate points and take the highest value
            long p = multiplier * ((long) processing.getCardAt(0).getNumber());
            if (p > points) {
                points = p;
            }

        }

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
     * Gets the players name
     * @return String of this player instances name
     * Otherwise returns "** NO ASSIGNED NAME **"
     */
    public String getName() {

        if(name == null||name.isEmpty()){
            return "** NO ASSIGNED NAME **";
        }

        return name;
    }

    /**
     * Prints out this players hand
     */
    public void print() {

        System.out.println("------ " + getName() + " ------");

        if (hand == null) {
            System.out.println("Player " + getName() + " has no cards");
            return;
        }
        hand.print();

        System.out.println("Player " + getName() + " has " + getPoints() + " points");

    }

}
