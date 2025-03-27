/**
 * This is the card class, it holds the details of a playing card
 * Its point value
 * and its string name or suit. if blank no name will be printed
 */
public class Card {

    private int number;             // The number value of this card
    private String suit;            // The suit, e.g., "hearts", "clubs", "spades", or "diamonds".

    // ***** Constructor *****

    /**
     * Initializes this card object
     * @param n The number/points value of this card
     * @param s The suit of this card - Can be any string
     */
    public Card(int n, String s) {

        number = n;
        suit = s;

    }

    // ***** Methods *****

    /**
     * Overrides equals to compare two Card objects
     * @param input The object you want to compare this card
     * @return True if Their points and suit are the same - otherwise false
     */
    @Override
    public boolean equals(Object input) {

        // Ensure valid input and cast card to "compare"
        if (!(input instanceof Card compare)) {
            return false;
        }

        //  Compares the card properties
        return compare.getSuit().equals(this.getSuit()) && compare.getNumber() == this.getNumber();
    }

    /**
     * Retrieves the integer representation of the card's number/points.
     * @return The number/points of this instance of card Default = "0"
     */
    public int getNumber() {

        return number;

    }

    /**
     * Retrieves the suit string of this card.
     * @return The suit / name of this card
     * Default = "** No Card Name **" .
     */
    public String getSuit() {

        // Check for empty or null string
        if (suit == null || suit.isEmpty()) {
            return "** No Card Name **" ;
        }

        // return suit/name
        return suit;
    }

    /**
     * Creates and formats a string representing this instance of card
     * Default suit = "** No Card Name **" Default card number = "0"
     * @return The string that represents this card
     */
    public String print(){

        // value of 11 , 12 , 13 generate names otherwise Card number only
        String cardName = switch (number) {
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> String.valueOf(number);
        };

        // Null/empty check for output string
        String suitOut = suit.isEmpty() ? "** No Card Name **" : suit;

        // Return formatted string
        return ("Card - " + String.format("%-6s" , cardName) + " of " + suitOut);
    }

}
