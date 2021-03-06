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

public class BlackJackApplication {
	// Welcome(instantiate) participants
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		BlackJackApplication bja = new BlackJackApplication();
		bja.launch();
	}

	private void launch() {
		boolean isPlayerStanding = false, isDealerStanding = false;

		// Dealer gets cards ready and displays
		System.out.println("\tHello, I will be your Blackjack Dealer today. Good Luck to you!\n");
		// Dealer gets a deck and show un-shuffled deck to Player
		System.out.println("Here's today's deck of cards:");
		dealer.producesDeck();
		System.out.println(dealer.getDeck().toString());
		// Dealer shuffles deck in front of Player
		dealer.shuffle();
//		System.out.println(dealer.getDeck().toString()); // for verification that deck was shuffled

		// Initial Cards to Player and Dealer
		// Deal and Display Cards (Dealer's first Face Down)
		dealCardsToPlayer(2);
		dealFirstCardToDealer();
		dealCardsToDealer(1);
		System.out.println("\nPlayer Total Points: " + player.getHandValue());
		System.out.println(player.toPlayerHandString() + "\n");
		System.out.println(dealer.toDealerHandString());

		// perform a check if both or one of the participants got a Blackjack (21 on the
		// initial Blackjack hand)
		checkIfBlackjack();

		// Player's turn
		do {
			// prompt Player to select an action
			int pChoice = playerChoiceSelection();
			// perform the action and keep asking for player's input if appropriate
			isPlayerStanding = handlePlayersChoice(pChoice);
		} while (!isPlayerStanding);

		// Dealer's turn
		// Display dealer's full hand and total value
		System.out.println(dealer.toString());
		System.out.println(dealer.getHandValue()  + "\n");
		do {
			isDealerStanding = dealerChoiceEnforcements();

			// check if dealer's hand is already over 21
			if (dealer.isBust()) {
				System.out.println("Dealer's Total Points: " + dealer.getHandValue());
				System.out.println("Dealer Busted!\nWINNER: Player!");
				exitBJApp();
			}

		} while (!isDealerStanding);

		// Determine winner if both player and dealer are standing
		if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Tie/Push");
			System.out.println(player.toPlayerHandString());
			System.out.println(dealer.toString());
			System.out.println("WINNERS: Player and Dealer\nThank you for playing. GoodBye!");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("WINNER: Player!");
			System.out.println("Player total: " + player.getHandValue());
			System.out.println("Dealer total: " + dealer.getHandValue() + "\n");
			exitBJApp();
		} else {
			System.out.println("WINNER: Dealer!");
			System.out.println("Dealer total: " + dealer.getHandValue());
			System.out.println("Player total: " + player.getHandValue() + "\n");
			exitBJApp();
		}

		// player's cards are cleared from table
		player.getBjh().clear();
		// dealer's cards are cleared from table
		dealer.getBjh().clear();
	} // end of launch()

	private void checkIfBlackjack() {
		// check if both get Blackjack at first hand dealt, if so Anounce the Tie/Push
		// and exit the game
		if (player.isBlackJack() && dealer.isBlackJack()) {
			System.out.println("BLACKJACK: BOTH! -- Dealer and Player have 21. Tie/Push!");
			System.out.println("WINNERS: Player and Dealer");
			System.out.println(dealer.toString());
			exitBJApp();
		} else if (player.isBlackJack()) {
			System.out.println("BLACKJACK: PLAYER!");
			System.out.println("WINNER: Player!");
			System.out.println(dealer.toString());
			exitBJApp();
		} else if (dealer.isBlackJack()) {
			System.out.println(dealer.toDealerHandString());
			System.out.println("BLACKJACK: DEALER!");
			System.out.println("WINNER: Dealer!");
			System.out.println(dealer.toString());
			exitBJApp();
		}
	}

	private void dealCardsToPlayer(int numOfCards) {
		// Player gets two cards face up
		for (int i = 0; i < numOfCards; i++) {
			player.cardForPlayer(dealer.dealCard());
			// add points to Player's hand
			player.getHandValue();
		}
	}

	private void dealCardsToDealer(int numOfCards) {
		// Dealer gets two cards First faces down, Second faces up
		for (int i = 0; i < numOfCards; i++) {
			dealer.cardForDealer(dealer.dealCard());
			// add points to Dealer's hand
			dealer.getHandValue();
		}
	}

	private void dealFirstCardToDealer() {
		dealer.cardForDealer(dealer.dealCard());
	}

	private void printPlayerMenu() {
		System.out.println("\nPlease select action: ");
		System.out.println("1. Hit ");
		System.out.println("2. Stand ");
		System.out.println("3. Print both Hands\n");
		System.out.println("9. Quit\n");
	}

	private boolean handlePlayersChoice(int userInput) {
		boolean isStanding = false;
		switch (userInput) {
		case 1:
			// Hit
			System.out.println("Player Hits");
			dealCardsToPlayer(1);
			System.out.println(player.toPlayerHandString());
			System.out.println("Player's Total Points: " + player.getHandValue());
			if (player.isBust()) {
				System.out.println("Player Busted!\nWINNER: Dealer!");
				exitBJApp();
			}
			break;
		case 2:
			// Stand
			System.out.println("Player Stands");
			System.out.println(player.getHandValue() + "\n");
			isStanding = true;
			break;
		case 3:
			// Printout both hands
			System.out.println(player.toPlayerHandString());
			System.out.println(dealer.toDealerHandString());
			break;
		case 9:
			// Exit program;
			exitBJApp(); // to break out completely without returning to launch();
		default:
			System.out.println("Somehow, you still got an invalid entry. Please try again.");
			break;
		}
		return isStanding;
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
				System.out.println("Invalid Entry. Please input a valid integer");
				pChoice = 0;
			}
		} while ((pChoice < 1 || pChoice > 3) && pChoice != 9);
		return pChoice;
	}

	private boolean dealerChoiceEnforcements() {
		boolean isDealerStanding = false;
		// if dealer's hand is 16 or less, it must hit
		if (dealer.getHandValue() <= 16) {
			System.out.println("Dealer Hits");
			dealCardsToDealer(1);
			System.out.println(dealer.toString());
			System.out.println(dealer.getHandValue() + "\n");
		} else {
			System.out.println("Dealer is Standing");
			System.out.println(dealer.getHandValue()  + "\n");
			isDealerStanding = true;
		}
		return isDealerStanding;
	}

	private void exitBJApp() {
		System.out.println("\nThank you for Playing. Goodbye!");
		// player's cards are cleared from table
		player.getBjh().clear();
		// dealer's cards are cleared from table
		dealer.getBjh().clear();
		kb.close();
		System.exit(0);
	}

} // end of class
