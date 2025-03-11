/**
 * This is the card class, it holds the details of a playing card
 */
public class Card {

    private int number;             // The number value of this card
    private String suit;            // The suit, e.g., "hearts", "clubs", "spades", or "diamonds".

    // ***** Constructor *****

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

        // Ensure valid input and case card to "compare"
        if (!(input instanceof Card compare)) {
            return false;
        }

        // Compare number and suit and return result
        return compare.getNumber() == this.number && compare.getSuit().equals(this.suit);
    }

    /**
     * This method retrieves the integer representation of the card's number.
     * @return The number of this instance of card
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retrieves the suit of this card.
     * @return The suit, e.g. "Hearts   <3 ", "Clubs   o8- ", "Spades  <-- ", or "Diamonds <> ".
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Creates and formats a string representing this instance of card
     * @return The string that represents this card
     */
    public String print(){

        // Generate the card name otherwise use a number
        // Advanced switch case Commented for personal note
        String cardName = switch (number) {
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> String.valueOf(number);
        };

        // Return formatted string
        return ("Card - " + String.format("%-6s" , cardName) + " of " + suit);
    }

}
