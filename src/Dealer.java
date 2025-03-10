import java.util.Random;

/**
 * A class to hold the details of the cards and the card dealer
 * Dealer will also announce the winner/s
 */
public class Dealer {

    // A list to hold the cards in the game
     private CardLinkedList deck = new CardLinkedList();

     // The version of deck you want to use
     private int deckVer;


    public Dealer( int d){

        deckVer = d;
        initDeck();
    }

    /**
     * Will deal "n" number of cards from this dealers deck
     * @return a CardLinkedList with the removed cards
     */
    public CardLinkedList dealCards(int n) {
        // If the deck has nothing in it, return nothing
        if (deck.isEmpty()) {
            return null;
        }

        // List for the cards to return and Random number generator
        CardLinkedList cards = new CardLinkedList();
        Random rand = new Random();

        // Removes "n" Number of cards at random from the deck
        for (int i = 0; i < n; i++) {
            if (deck.isEmpty()) {
                System.out.println("***** NO CARDS TO DEAL *****");
                return cards;
            }
            System.out.println("***** CARDS DEALT *****");

            int index = rand.nextInt(deck.getLength());
            cards.add(deck.removeAt(index));
        }

        return cards;
    }

    /**
     * Selects the deck to build and adds the correct cards to the deck
     */
    private void initDeck(){
        switch (deckVer){

            // Normal card deck
            case 1:
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
                break;

            // A deck of all hearts
            case 2:
                for(int i = 0; i < 52; i++){
                    Card addCard = new Card((1 + (i % 13)) , "Hearts   <3 ");
                    deck.add(addCard);
                }
                break;

            // Invalid deck
            default:
                System.out.println("***** INVALID DECK *****");
                break;
        }
    }

    /**
     * Just prints out all the cards the dealer currently has
     */
    public void print(){
        deck.print();
    }


}
