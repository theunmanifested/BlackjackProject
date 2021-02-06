/*  Storyline or Pseudocode practice. Step by step account to better design and implement a application
 *  
 * Player enters a casino, finds a Blackjack table, and sits down to play.
 * Player requests to play Blackjack with Basic rules (see Basic Rules below). Perhaps later he/she will go to another 
 * table where the rules are more complicated (Stretch Goals). The usual steps for a game of blackjack ensues:
 * 1. The Dealer produces a Deck, shuffles it, and shows/prints it
 * 2. Dealer gives out two Hands: 
 * 	a. Player with two cards facing up, 
 *  b. Dealer gets two cards with one facing up, and one facing down. 
 * 3. Player makes a choice to:
 *  a. Hit
 *  b. Stand
 * 4. Player wins if:
 *  a. Hand total is 21, and Dealer's hand total is not 21
 *  b. Hand total is higher than Dealer after dealer Stands
 *  c. Dealer busts
 * 5. Dealer wins if:
 * 	a. Hand total is 21, and Player's hand total is not 21
 *  b. Hand total is higher after Player stands
 *  c. Player busts
 * 6. Tie if both hands total is 21
 * 
 *  Object-Orientated Programming Design:
 *  
 * Classes:
 * - Card  - Rank  - Suit  - Deck  
 * - Hand (Abstract)(NotNow)  - Blackjack Hand
 * - Dealer  - Player
 * - Blackjack Application (this)
 *  
 * 
 * Basic Rules:
 *  - Aces value is 11
 *  - Dealer's total >= 17 must Stand, if total <= 16 must Hit
 *  - No Splitting
 *  - No Double-Down
 *  - No maximum of cards in hand *  
 * 
 * 
 * Notes:
 * - Only Blackjack Hand will be created for now. 
 * */

package com.skilldistillery.blackjack;

import java.util.*;
import com.skilldistillery.cards.*;

public class BlackJackApplication {
	// Welcome(instantiate) participants
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private Deck deck = new Deck();
	private Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {

		BlackJackApplication bja = new BlackJackApplication();
		bja.launch();
	}

	private void launch() {
		
		// Dealer gets cards ready
		deck = getCardsReady();
		
		// Initial Cards to Player and Dealer
		// Deal and Display Cards (Dealer's first Face Down)
		dealCardsToPlayer(2);
		dealFirstCardToDealer();
		dealCardsToDealer(1);
		System.out.println("Player Total Points: " + player.getpTotal());
		System.out.println(player.toPlayerHandString());
		System.out.println("Dealer Total Points: " + dealer.getdTotal());
		System.out.println(dealer.toDealerHandString());
		
		// Player's move (!isBust || !isBJ)
		// if Hit
			// Hit
			// Stand
			// Bust
			// BJ
		// if Stand - Dealer's turn
		// if Display Hands - Loop 
		// if Quit - Display Goodbye, and exit program
		
		// Dealer's move (!isBust || !isBJ)
		// if Hit
			// Hit
			// Stand
			// Bust
			// BJ
			// if Stand - Player's turn 		
		// TODO TODO TODO TODO
//		do {
			// prompt Player to select an action
			int pChoice = playerChoiceSelection();			
			// perform the action
			handlePlayersChoice(pChoice);
//		} while (!player.getBjh().isBlackjack(player.getpTotal()) || !player.getBjh().isBust(player.getpTotal()));
		
	}

	private Deck getCardsReady() {
		Deck prepDeck;
		System.out.println("\tHello, I will be your Blackjack Dealer today. Good Luck to you!\n");
		// Dealer gets a deck and show un-shuffled deck to Player
		System.out.println("Here's our deck of cards:");
		prepDeck = dealer.producesDeck();
		// TODO fix toString to printout better
		System.out.println(prepDeck.toString() + "\n");
		// Dealer shuffles deck in front of Player
		prepDeck.shuffle();
//		System.out.println(prepDeck.toString()); // for verification that deck was shuffled
		return prepDeck;
	}

	private void dealCardsToPlayer(int numOfCards) {
		Card currentCard;
		// Player gets two cards face up
		for (int i = 0; i < numOfCards; i++) {
			currentCard = deck.dealCard();
			player.cardForPlayer(currentCard);
			// add points to Player's hand
			player.setpTotal(currentCard.getValue());
		}
	}

	private void dealCardsToDealer(int numOfCards) {
		Card currentCard;
		// Dealer gets two cards First faces down, Second faces up
		for (int i = 0; i < numOfCards; i++) {
			currentCard = deck.dealCard();
			dealer.cardForDealer(currentCard);
			// add points to Dealer's hand
			dealer.setdTotal(currentCard.getValue());
		}
	}

	private void dealFirstCardToDealer() {
		Card currentCard;
		currentCard = deck.dealCard();
		dealer.cardForDealer(currentCard);
		// add points to Dealer's hand
		dealer.setdTotal(currentCard.getValue());
	}

	private void printPlayerMenu() {
		System.out.println("\nPlease select action: ");
		System.out.println("1. Hit ");
		System.out.println("2. Stand ");
		System.out.println("3. Print both Hands\n");
		System.out.println("9. Quit\n");
	}

	private void handlePlayersChoice(int userInput) {
		switch (userInput) {
		case 1:
			// Hit
			dealCardsToPlayer(1);
			System.out.println(player.toPlayerHandString());
			System.out.println("PlayeTotal Points: " + player.getpTotal());
			break;
		case 2:
			// Stand
			System.out.println("Player Stands\n");
			break;
		case 3:
			// Printout both hands
			System.out.println(player.toPlayerHandString());
			System.out.println(dealer.toDealerHandString());
			break;
		case 9:
			// Quit
			System.out.println("We thank you for playing our card game today. Have a good one!");
			System.exit(0);
		default:
			System.out.println("Somehow, you still got an invalid entry. Please try again.");
			break;
		}
	}

	private int playerChoiceSelection() {
		String captureStr = "";
		int pChoice = 0; // will force to pick a valid entry
		do {
			printPlayerMenu();
			captureStr = kb.nextLine();
			try {
				pChoice = Integer.parseInt(captureStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid Entry. Please input a valid integer");
				pChoice = 0;
			}
		} while ((pChoice < 1 || pChoice > 3) && pChoice != 9);
		return pChoice;
	}
	
	
} // end of class


