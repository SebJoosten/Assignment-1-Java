/**
 * This is the main body of assignment one
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("**** COMPX-201 Assignment 1 ****");
        System.out.println("**** Sebastiaan Joosten ****");

        /**
         * !!!!! READ ME !!!!!
         * I'm not totally sure how the game itself is meant to be implemented
         * There is a dealer class that holds all the rules and MAIN is used to set the order
         * This could also all be done in main, but we were taught not to do that so im confused
         */


        // Create a dealer with deck 1 generated
        CardDraw cardDraw= new CardDraw(1);

        // Add 10 players
        cardDraw.addPlayer(new Player("Jack"));
        cardDraw.addPlayer(new Player("Seb"));
        cardDraw.addPlayer(new Player("Josh"));
        cardDraw.addPlayer(new Player("Joe"));
        cardDraw.addPlayer(new Player("Laura"));
        cardDraw.addPlayer(new Player("Sabeen"));
        cardDraw.addPlayer(new Player("Kimi"));
        cardDraw.addPlayer(new Player("Ben"));
        cardDraw.addPlayer(new Player("The unknown"));
        cardDraw.addPlayer(new Player("Redacted"));

        // Deal each played 5 cards
        cardDraw.dealCards(5);

        // Print a list of dealers remaining cards and players cards
        cardDraw.printCards();

        // Prints a list of playyers and there cards
        cardDraw.printPlayers();

        // Rank the players and out put them in a nice list
        cardDraw.rankPlayers();

        // Restart GAME 2
        cardDraw.restartGame();

        // Add 10 players
        cardDraw.addPlayer(new Player("Jack"));
        cardDraw.addPlayer(new Player("Seb"));
        cardDraw.addPlayer(new Player("Josh"));
        cardDraw.addPlayer(new Player("Joe"));
        cardDraw.addPlayer(new Player("Laura"));
        cardDraw.addPlayer(new Player("Sabeen"));
        cardDraw.addPlayer(new Player("Kimi"));
        cardDraw.addPlayer(new Player("Ben"));
        cardDraw.addPlayer(new Player("The unknown"));
        cardDraw.addPlayer(new Player("Redacted"));

        // Deal each played 5 cards
        cardDraw.dealCards(5);

        // Print a list of dealers remaining cards and players cards
        cardDraw.printCards();

        // Prints a list of playyers and there cards
        cardDraw.printPlayers();

        // Rank the players and out put them in a nice list
        cardDraw.rankPlayers();




    }
}