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


        System.out.println("Dealer");
        CardLinkedList hand = new CardLinkedList();
        hand = dealer.dealCards(50);
        System.out.println("**** Hand ***\n");
        hand.print();




    }
}