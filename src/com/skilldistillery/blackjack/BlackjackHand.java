package com.skilldistillery.blackjack;

import java.util.*;

import com.skilldistillery.cards.Card;

public class BlackjackHand {
	protected List<Card> cards = new ArrayList<>();
	// constructor
	public BlackjackHand() {
		
	}
	
	// Hand methods
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		// TODO
	}
	
	public int getHandValue() {
		// TODO return temp
		int result = 0;
		return result;		
	}
	// Blackjack Hand methods
	public boolean isBlackjack(int points) {
		boolean isBlackjack = false;
		if (points == 21) {
			isBlackjack = true;
		} 		
		return isBlackjack;		
	}
	
	public boolean isBust(int points) {
		boolean isBust = false;
		if (points >= 22) {
			isBust = true;
		}		
		return isBust;		
	}

	
	public String toString() {
		// TODO test if printout is acceptable
		return "BlackjackHand [cards=" + cards + "]";
	}
	
	
}
