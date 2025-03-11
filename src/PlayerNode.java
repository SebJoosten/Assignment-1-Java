public class PlayerNode {


    private PlayerNode next;
    private Player thisPlayer;

    //***** constructor *****

    /**
     * Initializes this node with the input card
     * @param c The card you want to add to this node
     * @param n The next node in the chain
     */
    public PlayerNode(Player c, PlayerNode n) {
        thisPlayer = c;
        next = n;
    }

    //***** Methods *****

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
     * Gets the next node in the list from this one
     * @return The next node in this list
     */
    public PlayerNode getNext() {
        return next;
    }

    /**
     * A Simple method to return the card in this node
     * @return The player in this node
     */
    public Player isPlayer() {
        return thisPlayer;
    }

    /**
     * Prints the name of this player and there score
     */
    public void print(){
        thisPlayer.print();

        // if there is another node call its print Function
        if (next != null) { next.print(); }
    }

    public Player getPlayerAt(int n){
        n --;
        if (n == 0){
            return thisPlayer;
        }
        if(next == null){
            return null;
        }
        return next.getPlayerAt(n);

    }




}
