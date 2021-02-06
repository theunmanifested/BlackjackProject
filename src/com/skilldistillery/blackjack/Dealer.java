package com.skilldistillery.blackjack;

import com.skilldistillery.cards.*;

public class Dealer {
	private BlackjackHand bjh;
	private Deck deck;

	public Dealer() {
		bjh = new BlackjackHand();
	}
	
	public void cardForDealer(Card card) {		
		bjh.addCard(card);		
	} 
	
	public Deck producesDeck() {
		deck = new Deck();
		return deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public BlackjackHand getBjh() {
		return bjh;
	}

	public void setBjh(BlackjackHand bjh) {
		this.bjh = bjh;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		return bjh.toDealerHandString();
	}
	
	
	
}
