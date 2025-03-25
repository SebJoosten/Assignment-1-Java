/**
 * This is the main body of assignment one
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("**** COMPX-201 Assignment 1 ****");
        System.out.println("**** Sebastiaan Joosten ****");


        // Create a dealer with deck 1 generated
        Dealer dealer= new Dealer(1);

        // Add 10 players
        dealer.addPlayer(new Player("Jack"));
        dealer.addPlayer(new Player("Seb"));
        dealer.addPlayer(new Player("Josh"));
        dealer.addPlayer(new Player("Joe"));
        dealer.addPlayer(new Player("Laura"));
        dealer.addPlayer(new Player("Sabeen"));
        dealer.addPlayer(new Player("Kimi"));
        dealer.addPlayer(new Player("Ben"));
        dealer.addPlayer(new Player("The unknown"));
        dealer.addPlayer(new Player("Redacted"));

        // Deal each played 5 cards
        dealer.dealCards(5);

        // Print a list of dealers remaining cards and players cards
        dealer.printCards();

        // Prints a list of playyers and there cards
        dealer.printPlayers();

        // Rank the players and out put them in a nice list
        dealer.rankPlayers();

        // Restart GAME 2
        dealer.restartGame();

        // Add 10 players
        dealer.addPlayer(new Player("Jack"));
        dealer.addPlayer(new Player("Seb"));
        dealer.addPlayer(new Player("Josh"));
        dealer.addPlayer(new Player("Joe"));
        dealer.addPlayer(new Player("Laura"));
        dealer.addPlayer(new Player("Sabeen"));
        dealer.addPlayer(new Player("Kimi"));
        dealer.addPlayer(new Player("Ben"));
        dealer.addPlayer(new Player("The unknown"));
        dealer.addPlayer(new Player("Redacted"));

        // Deal each played 5 cards
        dealer.dealCards(5);

        // Print a list of dealers remaining cards and players cards
        dealer.printCards();

        // Prints a list of playyers and there cards
        dealer.printPlayers();

        // Rank the players and out put them in a nice list
        dealer.rankPlayers();




    }
}