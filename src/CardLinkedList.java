/**
 * This is the class to hold the linked list of cards in the card game
 * it can also check some operators of the list.
 * *** NODE CLASS AT BOTTOM ***
 */
public class CardLinkedList {

    // The top "head" of the list
    private Node head;

    //***** Constructor *****

    /**
     * Initializes this list with no cards in it
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
     * @param c The card your looking for value wise
     * @return True if found otherwise false
     */
    public boolean hasCard(Card c) {

        // If list is empty return false
        if (head == null) {
            return false;
        }

        // If list is populated send call down the nodes
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
            System.out.println("*** CARD INDEX OUT OF BOUNDS ***");
            return null;
        }

        // If deck is populated send the call down the list
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
            // Remove card from the list
            head = head.getNext();
            return;
        }

        // recursive call down the nodes if this node is not the card
        head.remove(c);
    }

    /**
     * Starts the print chain in this instance of list
     */
    public void print() {

        // Check list is populated
        if (head == null) {
            System.out.println("***** NO CARDS IN LIST *****");
            return;
        }

        // Call print down the rest of the nodes
        head.print();
    }


    //************ CARD NODE ************

    /**
     * Each node holds a card in the linked list
     * The nodes are not accessible outside CardLinkedList
     */
    private class Node {

        private Node next;
        private Card thisCard;

        //***** constructor *****

        /**
         * Initializes this node with the input card
         * @param c The card you want to add to this node
         * @param n The next node in the chain
         */
        public Node(Card c, Node n) {
            thisCard = c;
            next = n;
        }

        //***** Methods *****

        /**
         * A Method to search down the list and check for a card
         * @param c The card you want to look for
         * @return True if this is that card OR pass call to next node - false if no more nodes
         */
        public boolean hasCard(Card c) {

            // Return true if this node contains card = "c"
            if(thisCard.equals(c)) {
                return true;
            }

            // If there is another node continue down
            if(next != null) {
                return next.hasCard(c);
            }

            return false;
        }

        /**
         * A Method for counting the nodes in this Linked List
         * @param count The previous node count
         * @return The number of nodes
         */
        public int getLength(int count) {
            count ++;

            if(next != null) {
                return next.getLength(count);
            }

            return count;
        }

        /**
         * A method to look down the nodes for a specific index
         * @param count The current count of remaining index positions
         * @return The card at that index null check done in CardLinkedList Class
         *         NULL if index out of bounds
         */
        public Card getCard(int count) {
            // Count down by one and if not at 0 position move to next node
            count --;
            if(count == 0){
                return thisCard;
            }

            if(next == null) {
                System.out.println("*** CARD INDEX OUT OF BOUNDS ***");
                return null;
            }

            return next.getCard(count);
        }

        /**
         * Gets the next node in the list from this one
         * @return The next node in this list
         */
        public Node getNext() {
            if (next == null) {
                //System.out.println("*** END OF CARD LIST ***");
                return null;
            }
            return next;
        }

        /**
         * A Simple method to return the card in this node
         * @return The card in this node
         */
        public Card isCard() {
            return thisCard;
        }

        /**
         * Goes progressively down the list and looks for a card that matches the input
         * @param c The card you want to remove from this instance of list
         */
        public void remove(Card c) {

            // check if the next card is the one your looking for and remove it
            if (next.isCard() != null && next.isCard().equals(c)) {
                next = next.getNext();
                return;
            }

            // Pass down the call to next node
            next.remove(c);

        }

        /**
         * Just prints the value of this card in the console for checking
         */
        public void print(){
            System.out.println(thisCard.print());

            // if there is another node call its print Function
            if (next == null) { return; }
            next.print();
        }
    }

}

