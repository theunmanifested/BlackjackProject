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

import com.skilldistillery.cards.*;

public class BlackJackApplication {
	// Welcome(instantiate) participants
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();

	public static void main(String[] args) {

		BlackJackApplication bja = new BlackJackApplication();
		bja.launch();
	}

	private void launch() {
		// Dealer gets cards ready
		deck = getCardsReady();
		// Deal cards - descriptive
		dealCardsToPlayer();
	}

	private Deck getCardsReady() {
		Deck prepDeck;
		System.out.println("Hello, I will be your Blackjack Dealer today. Good Luck to you!");
		// Dealer gets a deck and show un-shuffled deck to Player

		System.out.println("Here's our deck of cards");
		prepDeck = dealer.producesDeck();
		// TODO fix toString to printout better
		System.out.println(prepDeck.toString());
		// Dealer shuffles deck in front of Player
		prepDeck.shuffle();
		System.out.println(prepDeck.toString()); // for verification that deck was shuffled
		return prepDeck;
	}

	private void dealCardsToPlayer() {
		// Player gets two cards face up
		System.out.println(deck.dealCard().toString());
		player.cardForPlayer(deck.dealCard());
		System.out.println(player.toString());
		player.cardForPlayer(deck.dealCard());
		System.out.println(player.toString());
	}
}
