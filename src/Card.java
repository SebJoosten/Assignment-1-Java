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
     * @param s The suit of this card
     */
    public Card(int n, String s) {
        number = n;
        suit = s;
    }

    // ***** Methods *****

    /**
     * Overrides equals to compare two Card objects
     * @param input The card you want to compare this instance
     * @return True if Their points are the same - otherwise false
     */
    @Override
    public boolean equals(Object input) {

        // Ensure valid input and cast card to "compare"
        if (!(input instanceof Card compare)) {
            return false;
        }

        //  Compares the card properties
        if (compare.getSuit().equals(this.getSuit()) && compare.getNumber() == this.getNumber()) {
            return true;
        }

        return false;
    }

    /**
     * This method retrieves the integer representation of the card's number/points.
     * @return The number/points of this instance of card
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retrieves the suit string of this card.
     * @return The suit / name of this card usually - ""Hearts   <3 ", "Clubs   o8- ", "Spades  <-- ", or "Diamonds <> ".
     * If no name was assigned will return "** No Card Name **"
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

        // Return formatted string
        return ("Card - " + String.format("%-6s" , cardName) + " of " + suit);
    }

}
