
// Used for random card picking
import java.util.Random;

/**
 * A class to hold the details of the cards and the card dealer *  will also announce the winner/s
 */
public class Dealer {

    // A list to hold the cards in the game
    private CardLinkedList deck = new CardLinkedList();

     // The version of deck you want to use
     private int deckVer;

    /**
     * Dealer constructor
     * @param d The deck type you want the dealer to generate
     *          1 = Standard 52 card deck
     *          2 = Deck with only hearts to generate higher chance of doubles
     *          3 = Deck of all the same card 52 times
     *          Default Normal 52 card deck
     */
    public Dealer( int d){
        deckVer = d;
        initDeck();
    }

    /**
     * Constructor for insertion of custom deck
     * @param d The CardLinkedList you wish this instance of dealer to use
     */
    public Dealer(CardLinkedList d){
        deck = d;
    }

    //****** Methods ******

    /**
     * Will deal "n" number of cards from this dealers deck
     * @return CardLinkedList with "n" number of cards - Empty list if no deck present or "n" = 0
     */
    public CardLinkedList dealCards(int n) {

        // List for the cards to return and Random number
        CardLinkedList cards = new CardLinkedList();
        Random rand = new Random();

        // Removes "n" Number of cards Or Empty list
        for (int i = 0; i < n; i++) {
            if (deck.isEmpty()) {
                System.out.println("***** NO CARDS DEALT *****");
                return cards;
            }

            // Pick a random card - remove it from deck - add it to return deck
            int index = rand.nextInt(deck.getLength());
            Card temp =  deck.getCardAt(index);
            cards.add(temp);
            deck.remove(temp);
        }

        return cards;
    }

    /**
     * Builds a deck based on what deckVer is present
     * Generated Standard deck if invalid or 0
     */
    private void initDeck(){
        switch (deckVer){

            // Normal card deck
            case 1:
                standardCardDeck();
                break;

            // A deck of all hearts also for testing
            case 2:
                for(int i = 0; i < 52; i++){
                    Card addCard = new Card((1 + (i % 13)) , "Hearts   <3 ");
                    deck.add(addCard);
                }
                break;

            // A deck of all the same card for testing
            case 3:
                for(int i = 0; i < 52; i++){
                    Card addCard = new Card((1) , "Diamonds   <3 ");
                }
                break;

            // Invalid selection deck apply standard deck
            default:
                System.out.println("***** INVALID DECK *****");
                System.out.println("*** DEFAULT  APPLIED ***");
                standardCardDeck();
                break;
        }

    }

    /**
     * Prints out all the cards the dealer currently has in this instance
     */
    public void print(){
        System.out.println("--- Dealers cards ---");
        deck.print();
        System.out.println("---------------------");
    }

    /**
     * Populated this dealers deck with a standard 52 card set
     */
    private void standardCardDeck(){
        for(int i = 0; i < 13; i++){
            Card addCard = new Card((i + 1) , "Hearts   <3 ");
            deck.add(addCard);
        }
        for(int i = 0; i < 13; i++){
            Card addCard = new Card((i + 1) , "Clubs   o8- ");
            deck.add(addCard);
        }
        for(int i = 0; i < 13; i++){
            Card addCard = new Card((i + 1) , "Spades  <-- ");
            deck.add(addCard);
        }
        for(int i = 0; i < 13; i++){
            Card addCard = new Card((i + 1) , "Diamonds <> ");
            deck.add(addCard);
        }
    }

}
