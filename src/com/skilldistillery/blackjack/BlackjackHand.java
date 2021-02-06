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
		for (Card card : cards) {
			result += card.getValue();
		}
		return result;
	}
	
	public String toString() {
		// TODO test if printout is acceptable
		return "BlackjackHand [cards=" + cards + "]";
	}

	public boolean isBlackJack() {
		boolean isBlackJack = false;
		if (getHandValue() == 21) {
			isBlackJack = true;
		}
		return isBlackJack;
	}

}
