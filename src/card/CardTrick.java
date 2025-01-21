package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        // Create a random hand of 7 cards
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            int value = rand.nextInt(13) + 1;  // Random value between 1 and 13
            String suit = Card.SUITS[rand.nextInt(4)];  // Random suit
            magicHand[i] = new Card(value, suit);  // Create new card and add to hand
        }

        // Display the magic hand of cards
        System.out.println("Your random magic hand of cards:");
        for (Card card : magicHand) {
            System.out.println(card);
        }

        try ( 
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Pick a card (e.g., Ace of Hearts, 10 of Diamonds): ");
            String userCardInput = scanner.nextLine().trim();
            
            
            boolean found = false;
            for (Card card : magicHand) {
                if (card.toString().equalsIgnoreCase(userCardInput)) {
                    found = true;
                    break;
                }
            }
            
            if (found) {
                System.out.println("Your card is in the magic hand!");
            } else {
                System.out.println("Your card is not in the magic hand.");
            }
            
            
            Card luckyCard = new Card(2, "Clubs");
            
            System.out.println("Lucky card: " + luckyCard);
            boolean foundLuckyCard = false;
            for (Card card : magicHand) {
                if (card.toString().equals(luckyCard.toString())) {
                    foundLuckyCard = true;
                    break;
                }
            }
            
            if (foundLuckyCard) {
                System.out.println("You found the lucky card: " + luckyCard);
            } else {
                System.out.println("Sorry, the lucky card is not in the magic hand.");
            }
        }
    }
}
