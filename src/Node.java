/**
 * Each node holds a card and holds the position in the linked list
 */
public class Node {

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
     */
    public Card getCard(int count) {
        // Count down by one and if not at 0 position move to next node
        count --;
        if(count <= 0){
            return thisCard;
        }
        return next.getCard(count);
    }

    /**
     * Gets the next node in the list from this one
     * @return The next node in this list
     */
    public Node getNext() {
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
        if (next != null) { next.print(); }
    }

}
