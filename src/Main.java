/**
 * This is the main body of assignment one
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("**** COMPX-201 Assignment 1 ****");
        System.out.println("**** Sebastiaan Joosten ****");


        // Create a dealer with deck 1 generated
        CardDraw cardDraw= new CardDraw(1);

        // Add 10 players
        cardDraw.addPlayer("Jack");
        cardDraw.addPlayer("Seb");
        cardDraw.addPlayer("Josh");
        cardDraw.addPlayer("Joe");
        cardDraw.addPlayer("Laura");
        cardDraw.addPlayer("Sabeen");
        cardDraw.addPlayer("Kimi");
        cardDraw.addPlayer("Ben");
        cardDraw.addPlayer("The unknown");
        cardDraw.addPlayer("Redacted");

        // Deal each played 5 cards
        cardDraw.dealCards(5);

        // Print a list of dealers remaining cards and players cards
        cardDraw.printCards();

        // Prints a list of players and there cards
        cardDraw.printPlayers();

        // Rank the players and out put them in a nice list
        cardDraw.rankPlayers();

        // Restart GAME 2
        cardDraw.restartGame();

        // Deal each played 5 cards
        cardDraw.dealCards(4);

        // Print a list of dealers remaining cards and players cards
        cardDraw.printCards();

        // Prints a list of players and there cards
        cardDraw.printPlayers();

        // Rank the players and out put them in a nice list
        cardDraw.rankPlayers();

        // clears all the players but doesn't reset the deck
        cardDraw.clearPlayers();

        // Debugger just abuses the deck for a bit
        /*
        Debugging debugging = new Debugging();
        debugging.resetDeck();
        debugging.makeRandomCards(1000);
        debugging.printDeck();
        debugging.abuseRemove(250);
        debugging.makeRandomCardStrings( 50 , 1000);
        debugging.printDeck();
        debugging.removeMoreThenLength();
        debugging.lookForRandomInvalidCard(500);
         */


    }
}