package com.skilldistillery.blackjack;

import com.skilldistillery.cards.*;

public class Player {
	private BlackjackHand bjh;
	private int pTotal = 0;

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

	public int getpTotal() {
		return pTotal;
	}

	public void setpTotal(int pTotal) {
		this.pTotal += pTotal;
	}

//	@Override
//	public String toString() {
//		return "Player [bjh=" + bjh + "]";
//	}
	
	public String toPlayerHandString() {
		return "Player's BlackjackHand [cards=" + bjh.cards + "]";
	}
	
	
	
	
}
