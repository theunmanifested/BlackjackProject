package com.skilldistillery.blackjack;

import com.skilldistillery.cards.*;

public class Player {
	private BlackjackHand bjh = new BlackjackHand();

	public Player() {
	}

	public void cardForPlayer(Card card) {		
		bjh.addCard(card);		
	} 
	
	@Override
	public String toString() {
		return "Player [bjh=" + bjh + "]";
	}

	public BlackjackHand getBjh() {
		return bjh;
	}

	public void setBjh(BlackjackHand bjh) {
		this.bjh = bjh;
	}

	
	
	
	
}
