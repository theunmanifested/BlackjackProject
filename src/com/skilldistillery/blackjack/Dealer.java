package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.*;

public class Dealer {
	private BlackjackHand bjh;
	private Deck deck;
	private int dTotal = 0;

	public int getdTotal() {
		return dTotal;
	}

	public void setdTotal(int dTotal) {
		this.dTotal += dTotal;
	}

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

	public String toDealerHandString() {
		List<Card> tempCards = new ArrayList<>(bjh.cards);
		tempCards.remove(0);
		return "Dealer's BlackjackHand [cards=[FaceDown Card], " + tempCards + "]";
	}
	

	
	
	
	
}
