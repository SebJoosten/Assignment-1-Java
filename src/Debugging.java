import java.util.Random;

/**
 * Debugger class has a few mothods to add/remove random cards
 * Remove more than in deck
 * add/Remove invalid and null cards
 */
public class Debugging
{

    CardLinkedList test;
    Random rand = new Random();

    /**
     * This makes a test CardLinkedList for testing
     * You can replace the test list with a custom list using addList(CardLinkedList());
     */
    public Debugging(){
        test = new CardLinkedList();
    }

    /**
     * Resets the testing deck
     */
    public void resetDeck(){
        CardLinkedList test = new CardLinkedList();
    }

    /**
     * Makes and adds random cards with random number and random string
     * @param n the number of cards you want to add
     */
    public void makeRandomCards (int n){

        System.out.println("Making random cards " + n + " and adding to list");

        for (int i = 0; i < n; i++) {
            Card c = new Card(rand.nextInt(), getRandomString(10) );
            test.add(c);
        }

    }

    /**
     * makes "n" random cards with string lengths of "s"
     * @param n The number of cards
     * @param s The length of string
     */
    public void makeRandomCardStrings (int n, int s){

        System.out.println("Adding " + n + " cards to the list");

        for (int i = 0; i < n; i++) {

            Card c = new Card(rand.nextInt(), getRandomString(s) );
            test.add(c);

        }

        System.out.println("Cards added to the list");

    }

    /**
     * A method to abuse the remove
     * @param n The number of cards you want to remove
     */
    public void abuseRemove(int n){

        System.out.println("Remove " + n + " cards");
        System.out.println("Deck has " + test.getLength() + " cards before removing");
        
        int removeCount = 0;
        int failedCount = 0;

        for (int i = 0; i < n; i++) {

            int randomIndex = rand.nextInt(test.getLength());
            Card c = test.getCardAt(randomIndex);
            test.remove(c);

            int i1 = (test.hasCard(c)) ? failedCount++ : removeCount++;

        }

        System.out.println(removeCount + " cards removed and " + failedCount + " cards failed");
        System.out.println("Deck has " + test.getLength() + " cards after removing");

    }

    /**
     * Prints out the deck
     */
    public void printDeck(){
        test.print();
    }

    /**
     * Removes More items than are in the list at random
     * Some indexes will be valid and some will be over
     */
    public void removeMoreThenLength() {

        System.out.println("Remove double deck number of cards");
        System.out.println("Deck has " + test.getLength() + " cards before removing");

        int n = test.getLength();
        int removedCount = 0;

        while (removedCount < n) {
            int randomIndex = rand.nextInt(-50, test.getLength() + 50);

            Card c = test.getCardAt(randomIndex);

            if (c != null) {
                test.remove(c);
                removedCount++;
            }
        }

        System.out.println("Deck has " + test.getLength() + " cards after removing");
    }

    /**
     * Removes "n" number of random cards
     * @param n The number of random cards to remove
     */
    public void lookForRandomInvalidCard(int n) {

        System.out.println("Attempting to remove " + n + " randomly generated invalid cards");
        System.out.println("Deck has " + test.getLength() + " cards before removing");

        for (int i = 0; i < n; i++) {
            // Generate a random invalid card (e.g., with a random number and random string)
            Card c = new Card(rand.nextInt(0, 10000), getRandomString(rand.nextInt(1, 100)));

            // Print out the random potentially invalid card
            System.out.println("Generated invalid card: " + c);

            test.remove(c);

        }

        System.out.println("Deck has " + test.getLength() + " cards after removing");

    }

    /**
     * Adds nulls to test card check
     * @param n The number of nulls to add
     */
    public void addNulls(int n){

        for (int i = 0; i < n; i++ ){
            test.add(null);
        }

    }

    /**
     * Replace default test list with custom list
     * @param c The CardLinkedList you wish to test
     */
    public void addList(Card c){

        test.add(c);

    }

    /**
     * Random string generator ripped from previous project
     * You can alter the "CHARACTERS" String to add other custom characters
     */
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length) {

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        }

        return sb.toString();

    }

}
