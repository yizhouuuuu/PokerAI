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
public class Card {
    private int rank;
    private int suite;
    
    public Card(){
        rank = 0;
        suite = 0;
    }
    
    public Card(int r, int s){
        rank = r;
        suite = s;
    }
    
    public int getSuite(){
        return suite;
    }
    
    public int getRank(){
        return rank;
    }
}
