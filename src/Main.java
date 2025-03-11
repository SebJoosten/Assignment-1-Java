//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * This is the main body of assignment one
 */




public class Main {
    public static void main(String[] args) {
        System.out.println("**** COMPX-201 Assignment 1 ****");
        System.out.println("**** Sebastiaan Joosten ****");





        Dealer dealer= new Dealer(1);


        dealer.addPlayer(new Player("Joosten"));
        dealer.addPlayer(new Player("Seb"));
        dealer.addPlayer(new Player("Josh"));
        dealer.addPlayer(new Player("testing"));

        dealer.printPlayers();

        int players = dealer.playerCount();

        dealer.dealCards(5);

        dealer.printPlayers();
        dealer.printPlayers();
        dealer.printCards();
        dealer.printCards();
        dealer.printPlayers();
        dealer.printPlayers();
        dealer.printCards();




    }
}