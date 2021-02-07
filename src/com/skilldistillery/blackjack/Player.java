package com.skilldistillery.blackjack;

import com.skilldistillery.cards.*;

public class Player {
	private BlackjackHand bjh;

	public Player() {
		bjh = new BlackjackHand();
	}

	public void cardForPlayer(Card card) {		
		bjh.addCard(card);		
	} 
	
	
	public BlackjackHand getBjh() {
		return bjh;
	}

	public void setBjh(BlackjackHand bjh) {
		this.bjh = bjh;
	}
	
	public String toPlayerHandString() {
		return "Player's BlackjackHand [cards=" + bjh.cards + "]";
	}
	
	public boolean isBust() {
		boolean isBust = false;
		if (bjh.getHandValue() >= 22) {
			isBust = true;
		}
		return isBust;
	}
	
	public boolean isBlackJack() {
		return bjh.isBlackJack();
	}
	
	public int getHandValue() {
		return bjh.getHandValue();
	}	
	
}
