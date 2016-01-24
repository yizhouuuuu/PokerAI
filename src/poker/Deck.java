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
    
    public void makeDeck(){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[4*i + j] = new Card(i, j);
            }
        }
    }
    
    public Card[] Deal(Card a, Card b) {
        int random;
        Card[] Dealt = new Card[7];
        int[] Used = new int[52];
        Used[4*a.getRank() + a.getSuite()] = 1;
        Used[4*b.getRank() + b.getSuite()] = 1;
        for (int i = 0; i < 7; i++) {
            random = (int) Math.floor(Math.random()*51);
                if (Used[random] == 1) {
                    while (Used[(random + 1) % 52] == 1) {
                        random++;
                    }
                    Dealt[i] = deck[(random + 1) % 52];
                    Used[(random + 1) % 52] = 1;
                }
                else {
                    Dealt[i] = deck[random % 52];
                    Used[random] = 1;
                }
        }
        return Dealt;
    }
}
