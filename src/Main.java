//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * This is the main body of assignment one
 */




public class Main {
    public static void main(String[] args) {
        System.out.println("**** COMPX-201 Assignment 1 ****");
        System.out.println("**** Sebastiaan Joosten ****");

        CardLinkedList cards = new CardLinkedList();

        System.out.println(cards.getLength());

        Card cardA = new Card(2 , "heart" );
        Card cardB = new Card(2 , "heart" );
        Card cardC = new Card(3 , "heart" );
        Card cardD = new Card(4 , "heart" );
        Card cardE = new Card(5 , "heart" );

        // Test equals
        System.out.println(cardA.equals(cardB));
        System.out.println(cardA.equals(cardC));

        // Test add cards
        cards.add(cardA);
        cards.add(cardB);
        cards.add(cardC);
        cards.add(cardD);


        // Test Get lengeth
        System.out.println(cards.getLength());

        System.out.println(cards.hasCard(cardA));
        System.out.println(cards.hasCard(cardE));


        // Test get cards at index
        System.out.println(cards.getCardAt(1).print());
        System.out.println(cards.getCardAt(2).print());
        System.out.println(cards.getCardAt(3).print());
        System.out.println(cards.getCardAt(4).print());

        if(cards.getCardAt(5) != null) {
            System.out.println(cards.getCardAt(5).print());

        }

        cards.remove(cardA);
        System.out.println(cards.getLength());
        cards.print();

    }
}