
// Used for random card picking
import java.util.Random;

/**
 * This is the game dealer
 * The dealer is either given cards or asked to generate a standard deck
 * The dealer is given the players in this game
 * The dealer also deals cards and calculates points
 * *** PLAYER NODE AT BOTTOM ***
 */
public class Dealer {

    // A list to hold the cards in the game and the first node
    private CardLinkedList deck = new CardLinkedList();
    private PlayerNode firstPlayer;

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
        firstPlayer = null;
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
     * Will deal "n" number of random cards and remove them from dealers deck
     * The dealer will deal cards to the players in this instance
     * @return CardLinkedList with "n" number of cards - Empty list if no deck present or "n" = 0
     */
    private CardLinkedList randomCards(int n) {

        // List for the cards to return and Random number object
        CardLinkedList cards = new CardLinkedList();
        Random rand = new Random();

        // Removes "n" Number of cards
        for (int i = 0; i < n; i++) {
            if (deck.isEmpty()) {

                // If the dealer ran out of cards prints message but continues
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
     * Deals all the players in this dealers control "n" number of cards
     * If no cards left the dealer will deal empty hands and print message
     * Make sure you have enough cards for the rules you would like to use
     * @param n the number of cards dealt to each player under this dealers control
     *          EMPTY HANDS DEALT if dealer runs out of cards
     */
    public void dealCards(int n) {

        for (int i = 0; i < playerCount(); i++) {

            // Make a hand and get a player
            CardLinkedList newHand = randomCards(n);
            Player p = getPlayerAtIndex(i);

            // Null check with error if return fails
            if (newHand != null && p != null) {
                p.giveCards(newHand);
            } else {
                System.out.println("***** NO CARDS DEALT *****");
            }
        }
    }

    /**
     * Returns the player at that index
     * @param index The player number you want from the list
     * @return The player at that index in the list
     */
    private Player getPlayerAtIndex(int index) {
        if (index < 0 || index >= playerCount()) {
            return null;
        }
        return firstPlayer.getPlayerAt(index);
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

    /**
     * Builds a deck based on what deckVer is present
     * Generated Standard deck if invalid or 0
     *      1 = Standard 52 card deck
     *      2 = Deck with only hearts to generate higher chance of doubles
     *      3 = Deck of all the same card 52 times
     *      Default Normal 52 card deck
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
                    deck.add(addCard);
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
    public void printCards(){
        System.out.println("--- Dealers cards ---");

        if (!deck.isEmpty() || deck != null) {
            deck.print();
        }

        System.out.println("---------------------");
    }

    /**
     * Prints out a list of all the players this dealer manages
     */
    public void printPlayers(){
        if(firstPlayer == null){
            System.out.println("***** No Players *****");
        } else {
            System.out.println("---    Players    ---");
            firstPlayer.print();
            System.out.println("---------------------");
        }
    }

    /**
     * Adds a new player under this instance of dealers control
     * @param p The player instance you wish to add
     */
    public void addPlayer(Player p) {

        // Check to avoid null adds
        if(p == null) {
            System.out.println("***** INVALID PLAYER *****");
            return;
        }

        // Add a player to this dealer
        firstPlayer = new PlayerNode(p, firstPlayer);
    }

    /**
     * Starts a recursive call down the nodes to get the number of Players
     * @return The number of Players otherwise 0 if no players
     */
    public int playerCount() {
        if(firstPlayer == null) { return 0; }
        return firstPlayer.getLength(0);
    }

    /**
     * Remove all the players and make a new deck of this instances choice
     * If you wish to use different cards create a new instance of dealer
     */
    public void restartGame(){
        firstPlayer = null;
        deck = new CardLinkedList();
        initDeck();
    }

    /**
     * This is a method to take all the players in this dealers control and see who has won
     * It will print out a list inorder of all the players and there total points
     */
    public void rankPlayers(){

        System.out.println("********** RANKING **********");

        // Loads player names and points in to working arrays
        int[] pointsList = new int[playerCount()];
        String[] playerNames = new String[playerCount()];

        for(int i = 0; i < playerCount(); i++){
            Player p = getPlayerAtIndex(i);
            if (p != null) {
                pointsList[i] = (int) p.getPoints();
                playerNames[i] = (String) p.getName();
            }
        }

        // Order the arrays and names
        for (int i = 0; i < pointsList.length; i++) {
            for (int j = i + 1; j < pointsList.length; j++) {
                // Sort the players and their points in descending order
                if (pointsList[i] < pointsList[j]) {
                    // Swap points
                    int p = pointsList[i];
                    pointsList[i] = pointsList[j];
                    pointsList[j] = p;

                    // Swap player names
                    String n = playerNames[i];
                    playerNames[i] = playerNames[j];
                    playerNames[j] = n;
                }
            }
        }

        // Formats output strings and checks for ties
        // Increments as ranks are calculated represents 1st 2nd 3rd so on
        int rankOffset = 0;

        for (int i = 0; i < pointsList.length; i++) {

            // Checks if this value has been processed as tie
            if (pointsList[i] == -1) continue;

            // String builder for output string compilation
            StringBuilder outPut = new StringBuilder();
            outPut.append(String.format("%2d - %12s", (i + 1) - rankOffset, playerNames[i]));

            // Tie off set increments every time there is another tie
            int tieOffset = 0;

            // While 2 points values next to each-other match combine their name strings
            while (i + 1 + tieOffset < pointsList.length && pointsList[i] == pointsList[i + 1 + tieOffset]) {
                outPut.append(" = ").append(String.format(playerNames[i + 1 + tieOffset]));
                rankOffset++;
                pointsList[i + 1 + tieOffset] = -1;
                tieOffset++;
            }

            // Append points to string and print
            outPut.append(" with ").append(pointsList[i]).append(" points");
            System.out.println(outPut);

        }

        System.out.println("-----------------------------");

    }

    // ********** Player Node **********

    /**
     * This is a node used for a linked list of players.
     * Only the dealer can use this node use .addPlayer to add a player
     */
    private class PlayerNode {

        // The next node in the list, null if last
        private PlayerNode next;
        // The player in this node
        private Player thisPlayer;

        //***** constructor *****

        /**
         * Initializes this node with the input card
         * @param p The player in this node
         * @param n The next node in the chain
         */
        public PlayerNode(Player p, PlayerNode n) {
            thisPlayer = p;
            next = n;
        }

        //***** Methods *****

        /**
         * A Method for counting the nodes in this Linked List
         * @param count The previous node count
         * @return previous node count + 1 if last otherwise continue down the list
         */
        public int getLength(int count) {

            count ++;

            // Check for next otherwise return count
            return (next != null) ? next.getLength(count) : count;
        }

        /**
         * Gets the next node in the list from this one
         * Can only be accessed by dealer
         * @return The next node in this list or NULL if last node
         */
        public PlayerNode getNext() {

            return (next == null) ? null : next;

        }

        /**
         * Prints the name of this player and there score
         */
        public void print(){

            thisPlayer.print();

            // if there is another node call its print Function
            if (next != null) next.print();

        }

        /**
         * Return a player at a specific index
         * @param n The player position you want from the list
         * @return The player at that position in the list otherwise NULL
         */
        public Player getPlayerAt(int n){

            // Return the player if count is 0
            if (n == 0){
                return thisPlayer;
            }

            // Check next null, print error and return
            if(next == null){
                System.out.println("***** INVALID PLAYER *****");
                return null;
            }

            // Otherwise keep calling
            return next.getPlayerAt(n -1);

        }

    }

}
