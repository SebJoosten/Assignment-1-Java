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

        Player test = new Player("testing");
        //dealer.addPlayer(new Player("Joosten"));
        //dealer.addPlayer(new Player("Seb"));
       // dealer.addPlayer(new Player("Josh1"));
        //dealer.addPlayer(new Player("Jos2"));
        //dealer.addPlayer(new Player("Josh3"));
        //dealer.addPlayer(new Player("Josh4"));
        //dealer.addPlayer(new Player("Josh5"));
        //dealer.addPlayer(new Player("Josh6"));

        dealer.addPlayer(test);

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
        test.print();
        System.out.println(test.getPoints());



    }
}