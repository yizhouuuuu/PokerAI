/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.util.*;
/**
 *
 * @author Max
 */
public class Card implements Comparable{
    private int rank;
    private int suite;
    
    public Card(){
        this.rank = 0;
        this.suite = 0;
    }
    
    public Card(int r, int s){
        this.rank = r;
        this.suite = s;
    }
    
    public int getSuite(){
        return this.suite;
    }
    
    public int getRank(){
        return this.rank;
    }

	public int compareTo(Card c) {	//compare ranks
		if ( this.rank == 0 ) {	//if this card is an ace it's higher unless the other card is also an ace
			if ( c.getRank() == 0 ) { return 0; }
			else { return 1; }
		} else if ( c.getRank() == 0 ) { return -1; }
		else {
			return ( this.rank.compareTo( c.getRank() ) );
		}
	}
}
