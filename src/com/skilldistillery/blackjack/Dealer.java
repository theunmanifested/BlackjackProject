package com.skilldistillery.blackjack;

import com.skilldistillery.cards.*;

public class Dealer {
	private BlackjackHand bjh;
	private Deck deck;

	public Dealer() {
	}
	
	public Deck producesDeck() {
		deck = new Deck();
		return deck;
	}

	public Deck getDeck() {
		return deck;
	}
	
	
}
