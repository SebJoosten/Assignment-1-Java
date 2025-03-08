

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
     * A Method to check if the list is empty or not
     * @return True if empty, False if populated
     */
    public boolean isEmpty() {
        if (head == null) { return true; }
        return false;
    }

    /**
     * Starts a recursive call down the chain to get the number of cards in this card list
     * @return The number of counter cards, 0 if no cards in list
     */
    public int getLength() {
        if(head == null) { return 0; }
        return head.getLength(0);
    }

    /**
     * This Method is to check if a specific card is in the list
     * @param c The card your looking for
     * @return True if found false if not
     */
    public boolean hasCard(Card c) {
        if (head == null) {return false;}
        return head.hasCard(c);
    }

    /**
     * A Method to get a card as a specific index
     * @param index The card index your looking for
     * @return The Card at that index OR null if index out of bounds
     */
    public Card getCardAt(int index) {
        if(head == null || index > getLength()) { return null; }
        return head.getCard(index);
    }

    /**
     * This method adds a new node to the list
     * @param c The card contained inside this node
     */
    public void add(Card c) {
        if(c == null) {
            System.out.println("INVALID CARD ADD");
            return;
        }
        System.out.println("Adding Card: " + c.print());
        Node n = new Node(c, head);
            head = n;
    }


    public void remove(Card c) {
        if (c == null || head == null) {
            System.out.println("INVALID CARD REMOVE");
            return;
        }


        if (head.isCard() != null && head.isCard().equals(c)) {
            head = head.getNext();  // Remove the head if it matches
            return;
        }

        head.remove(c);  // Recursively check the next node
    }


    public void print() {
        head.print();
    }
}
