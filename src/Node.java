/**
 * Each node holds a card and holds the position in the linked list
 */


public class Node {

    private Node next;
    private Card thisCard;

    //***** constructor *****

    /**
     * initializes this node with the input card
     * @param c The card you want to add to this node
     */
    public Node(Card c, Node n) {
        thisCard = c;
        next = n;
    }

    //***** Methods *****

    /**
     * A recursive method to search down the list and check for a card
     * @param c The card you want to look for
     * @return True if this is that card and recursive if not OR false if at end of list
     */
    public boolean hasCard(Card c) {
        if(thisCard.equals(c)) { return true; }
        if(next != null) { return next.hasCard(c); }
        return false;
    }

    /**
     * A Method for counting the nodes in this Linked List
     * @param count The previous node count
     * @return The number of nodes
     */
    public int getLength(int count) {
        count ++;
        if(next != null) { return next.getLength(count); }
        return count;
    }

    /**
     * A method to look down the nodes for a specific index
     * @param count The current count of remaining index positions
     * @return The card at that index null check done in CardLinkedList Class
     */
    public Card getCard(int count) {
        // count down by one and if not at 0 position move to next node
        count --;
        if(count == 0){
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

    public Card isCard() {
        return thisCard;
    }



    public void remove(Card c) {

        if (next.isCard() != null && next.isCard().equals(c)) {
            next = next.getNext();  // Remove the head if it matches
            return;
        }
         next.remove(c);  // Recursively check the next node

    }


    public void print(){
        System.out.println(thisCard.print());
        if (next != null) { next.print(); }
    }

}
