package com.skilldistillery.blackjack;

import java.util.*;

import com.skilldistillery.cards.*;

public abstract class Hand extends BlackjackHand{
	protected List<Card> cards;
	// constructor
	public Hand() {
		
	}
	
	public void addCard(Card card) {
		// TODO
	}
	
	public void clear() {
		// TODO
	}
	
	public abstract int getHandValue();

	// TODO Test
	@Override
	public String toString() {
		return "Hand []";
	}
	
	
	
}
