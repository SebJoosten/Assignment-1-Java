/**
 * This is the card class it holds the details of a playing card and its Parameters
 */

public class Card {

    private int number;             // The number value of this card
    private String suit;            // The suit, e.g., "hearts", "clubs", "spades", or "diamonds".

    // ***** Constructors *****

    /**
     * Initializes this card object
     * @param n The number value of this card 1 ~ 10
     * @param s The suit of this card
     */
    public Card(int n, String s) {
        number = n;
        suit = s;
    }

    // ***** Methods *****

    /**
     * Overrides equals to compare two Card objects
     * @param input The card you want to compare this to
     * @return True if they are the same false otherwise
     */
    @Override
    public boolean equals(Object input) {
        // Ensure valid input
        if (!(input instanceof Card compare)) {
            return false;
        }

        // Compare number and suit false if different
        return compare.getNumber() == this.number && compare.getSuit().equals(this.suit);
    }

    /**
     * This method retrieves the integer representation of the card's number.
     * @return The number of this card
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retrieves the suit of this card.
     * @return The suit, e.g., "hearts", "clubs", "spades", or "diamonds".
     */
    public String getSuit() {
        return suit;
    }

    /**
     * This makes a string of the value of this card
     * @return The string that represents thins card
     */
    public String print(){
        return ("Card - " + suit + " of " + number);
    }


}
