/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author Max
 */
public class Deck {
    private Card[] deck = new Card[52];
    public Deck (){
        
    }
    
    public void makeDeck(){	//assigns the deck to contain every one of the 52 cards
        for (int i = 0; i <= 12; i++) {	//i is the rank
            for (int j = 0; j <= 3; j++) {	//j is the suit
                deck[ 4 * i + j ] = new Card(i, j);
            }
        }
    }
    
    public Card[] Deal(Card a, Card b) {	//where 'a' and 'b' are your hole cards
        int random;
        Card[] Dealt = new Card[7];	//The 7 cards that are going to be dealt out, 2 opponent hole cards, 5 community
        int[] Used = new int[52];	//The cards that we've already dealt out
		//setting hole cards as being dealt out
        Used[ 4 * a.getRank() + a.getSuite() ] = 1;
        Used[ 4 * b.getRank() + b.getSuite() ] = 1;
		//Only doing heads-up so far so 5 com, 2 opponent
        for (int i = 0; i < 7; i++) {
            random = (int) Math.floor(Math.random() * 52);	//math.random outputs from [0,1)
                if (Used[random] == 1) {	//if card is already taken, go to the next card until we find one that's not taken
                    while (Used[(random + 1) % 52] == 1) {	//ends when the next card isn't taken
                        random++;
                    }
					//putting the card into dealt and marking it as used
                    Dealt[i] = deck[(random + 1) % 52];
                    Used[(random + 1) % 52] = 1;
                }
                else {	//if it's not used then immediately deal it out
                    Dealt[i] = deck[random % 52];
                    Used[random] = 1;
                }
        }
        return Dealt;
    }
}

