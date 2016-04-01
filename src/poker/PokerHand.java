/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.lang.Math;
import java.util.*;
/**
 *
 * @author Max
 * @author Owen
 */
public class PokerHand {
	private Card[] hand = new Card[5];
	public int[] cardRanks = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};	//14 0s
	private int[] suites = {0,0,0,0};

	public PokerHand(){

	}

	public void setPokerHand(Card a, Card b, Card c, Card d, Card e){
		hand[0] = a;
		hand[1] = b;
		hand[2] = c;
		hand[3] = d;
		hand[4] = e;
		Arrays.sort( hand );	//sorting the hand
		ArrayUtils.reverse( hand );	//reversing the order to be highest to lowest
	}

	public void countCards(){
		for (int i = 0; i <= 4; i++){	//go through 5 cards and count each suite and rank
			suites[hand[i].getSuite()]++;
			cardRanks[hand[i].getRank()]++;
		}
		cardRanks[13] = cardRanks[0];	//Aces indexed as 0 and 13
	}

	public void resetCount(){
		for (int i = 0; i < 5; i++){
			suites[hand[i].getSuite()] = 0;
			cardRanks[hand[i].getRank()] = 0;
		}
	}

	//2-pair weight 14^2, single pair weight 14^1
	//kicker not implemented
	public long pair(){
		int[] pairs = {-1, -1};	//holds the ranks of pairs, 2-pair 7 and 2 will be (6,1)
		int n = 0;
		//if there's 2 cards in the same rank we have a pair, go down descending so the first pair is higher
		for (int i = 12; i >= 0; i--) {
			if (cardRanks[i] == 2){
				pairs[n++] = i;
			}
		}

		if (pairs[0] == 0){	//pair of aces wrap around
			pairs[0] = 13;
		}

		if (pairs[1] != -1){	//if we have 2-pair
			return Math.pow(14, 2) * pairs[0] + Math.pow(14, 1) * pairs[1];
		} else if(pairs[0] != -1){	//if we have only 1 pair
			return Math.pow(14, 1) * pairs[0];
		} else {	//no pairs
			return 0;
		}
	}

	//set weight of 14^3
	//kicker not implemented
	public long set(){
		for (int i = 12; i >= 0; i--){
			if (cardRanks[i] == 3){	//if we have a set
				if (i == 0) {	//set of aces
					return (long) Math.pow(14, 3) * 13;
				} else {
					return (long) Math.pow(14, 3) * i;
				}
			}
		}
		//if we don't find a set
		return 0;
	}

	//straight weight of 14^4
	public long straight(){
		for (int i = 0; i <= 9; i++){	//check 5 consecutive cards are present
			for (int j = 0; j <= 4; j++){
				if (cardRanks[(i + j) % 13] == 1){	//accounting for wrap around to aces
					if (j == 4) {
						return (long) Math.pow(14, 4) * (i + j);
					}
				} else {
					break;
				}
			}
		}
		return 0;
	}

	//flush weight of 14^5
	public long flush(){
		int ace = 0;
		for (int i = 0; i <= 3; i++){	//checking each suit
			if (suites[i] == 5){	//if there're 5 of the same suit
				for (int cardNumber = 0; i < 5; i++) {
					if ( hand[0] == 0 ) {
						ace = 13;
					}
				}
				return (long) ( Math.pow(14, 5) * ( hand[0] + ace ) + Math.pow(14, 4) * hand[1] + Math.pow(14,3) * hand[2] + Math.pow(14,2) * hand[3] + Math.pow(14,1) * hand[4] );
			}
		}
		return 0;
	}

	//trip weight 14^3, pair weight 14^1; total weight of 14^6
	public long fullHouse(){
		if ( (this.pair() != 0) && (this.set() != 0) ) {	//pair + trip = fullhouse
			return Math.pow(14, 1) * this.pair() + (long) Math.pow(14, 3) * this.set();
		}
		return 0;
	}

	//fOAK weight of 14^7
	public long fOAK(){
		for (int i = 12; i >= 0; i--){
			if (cardRanks[i] == 4){	//if we have a fOAK
				if (i == 0){	//aces quad
					return (long) Math.pow(14, 7) * 13;
				} else {
					return (long) Math.pow(14, 7) * i;
				}
			}
		}
		return 0;
	}

	//SF weight of 14^8
	public long straightFlush(){
		if ((this.straight()!= 0) && (this.flush()!= 0)){
			return (long) Math.pow(14,4) * this.straight();
		}
		return 0;
	}



	public long evaluate(){
		long[] hands= {this.straightFlush(), this.fOAK(), this.fullHouse(), this.flush(), this.straight(), this.set(), this.pair()};
		for (int i = 0; i < 7; i++){	//picks the highest hand
			if (hands[i] != 0){
				return hands[i];
			}
		}
		//for (int i = 13; i > -1; i--){	//high card
		//	if (cardRanks[i] != 0){
		//		return i;
		//	}
		//}
		return hand[0];	//high card (since we sorted)

		return 0;
	}
}
