
/**
 * This is the class to hold the linked list of cards in the card game
 * it can also check some operators of the list.
 */
public class CardLinkedList {

    // The top "head" of the list
    private Node head;

    //***** Constructor *****

    /**
     * initializes this list with no cards in it
     */
    public CardLinkedList() {
        head = null;
    }

    //***** Methods *****

    /**
     * Method to check if the list is empty or not
     * @return True if empty, False if populated
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Starts a recursive call down the nodes to get the number of cards in this card list
     * @return The number of counter cards, 0 if no cards in list
     */
    public int getLength() {
        if(head == null) { return 0; }
        return head.getLength(0);
    }

    /**
     * Checks for a card of the same value in this instance of CardLinkedList
     * @param c The card with the paramators your looking for
     * @return True if found otherwise false
     */
    public boolean hasCard(Card c) {
        // if list is empty return false
        if (head == null) {
            return false;
        }

        // if list is populated send call down the nodes
        return head.hasCard(c);
    }

    /**
     * Get a card as a specific index in this instance of CardLinkedList
     * @param index The card index your looking for
     * @return The Card at that index OR null if index out of bounds
     */
    public Card getCardAt(int index) {
        // Check deck is populated or index is valid
        if(head == null || index > getLength()) {
            return null;
        }

        // if deck is populated send the call down the list
        return head.getCard(index);
    }

    /**
     * Adds a new node to the list
     * @param c The card you wish to add to this instance of list - Invalid card will just return
     */
    public void add(Card c) {
        // Check to avoid null adds
        if(c == null) {
            System.out.println("***** INVALID CARD ADD *****");
            return;
        }

        // Add the card to a new node in the list
        head = new Node(c, head);
    }

    /**
     * Remove a specific card in this list
     * @param c The card you want to remove
     */
    public void remove(Card c) {

        // Check there is objects in the list and c is not null
        if (c == null || head == null) {
            System.out.println("***** INVALID CARD REMOVE *****");
            return;
        }

        // Checks the head before passing down the nodes
        if (head.isCard() != null && head.isCard().equals(c)) {
            head = head.getNext();
            return;
        }

        // Check down the rest of the nodes
        head.remove(c);
    }

    /**
     * Starts the print chain in this instance of list
     */
    public void print() {

        // Check list is populated
        if (head == null) {
            System.out.println("***** NO CARDS TO PRINT *****");
            return;
        }

        // Call print down the rest of the nodes
        head.print();
    }


    //******************** incomplete ********************
    /**
     * Remove a card at position "n" from the list
     * @param index the position you want to remove the card from
     */
    public Card removeAt(int n) {
        //if (n  - 1 > getLength()) {
        //    System.out.println("INVALID CARD REMOVE");
        //    return null;
       // }

        // Get the card at the index and remove it from this instance of the list
        Card temp = head.getCard(n);
        remove(temp);
        return temp;
    }


}
