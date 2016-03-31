/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.lang.Math;
/**
 *
 * @author Max
 * @author Owen
 */
public class PokerHand {
    private Card[] hand = new Card[5];
    public int[] cardRanks = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] suites = {0,0,0,0};
    
    public PokerHand(){
        
    }
    
    public void setPokerHand(Card a, Card b, Card c, Card d, Card e){
        hand[0] = a;
        hand[1] = b;
        hand[2] = c;
        hand[3] = d;
        hand[4] = e;
        //implement sorting thing here
    }
    
    public void countCards(){
        for (int i = 0; i < 5; i++){
            suites[hand[i].getSuite()]++;
            cardRanks[hand[i].getRank()]++;
        }
        cardRanks[13] = cardRanks[0];
    }
    
    public void resetCount(){
        for (int i = 0; i < 5; i++){
            suites[hand[i].getSuite()] = 0;
            cardRanks[hand[i].getRank()] = 0;
        }
    }
    
    
    public long pair(){
        int[] pairs = {-1, -1};
        int n = 0;
        for (int i = 1; i < 13; i++){
            if (cardRanks[i] == 2){
                pairs[n] = i;
                n++;
            }
        }
        if (pairs[0] == 0){
            pairs[0] = 13;
        }
        if (pairs[1]!=-1){
            
            return 14*14*pairs[0] + 14*pairs[1];
        } else if(pairs[0]!=-1){
            return 14*pairs[0];
        } else{
            return 0;
        }
    }
    
    public long set(){
        for (int i = 1; i < 13; i++){
            if (cardRanks[i] == 3){
                if (i == 0){
                    return (long) Math.pow(14,3)*13;
                } else {
                return (long) Math.pow(14,3)*i;
                }
            }
        }
        return 0;
    }
    
    public long fOAK(){
        for (int i = 1; i < 13; i++){
            if (cardRanks[i] == 4){
                if (i == 0){
                    return (long) Math.pow(14,7)*13;
                } else {
                return (long) Math.pow(14,7)*i;
                }
            }
        }
        return 0;
    }
    
    public long fullHouse(){
        if ((this.pair()!=0)&&(this.set()!= 0)){
            return this.pair() + (long) Math.pow(14,3)*this.set();
        }
        return 0;
    }
    
    public long straight(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 5; j++){
                if (cardRanks[i+j] == 1){
                    if (j == 4) {
                        return (long) Math.pow(14,4)*(i + j);
                    }
                } else {
                    break;
                }
            }
        }
        return 0;
    }
    
    public long flush(){
        for (int i = 0; i < 4; i++){
            if (suites[i] == 5){
                return (long) Math.pow(14,5)*hand[0].getRank() + (long) Math.pow(14,4)*hand[1].getRank() + (long) Math.pow(14,3)*hand[2].getRank()  + (long) Math.pow(14,2)*hand[3].getRank() + 14*hand[4].getRank();
            }
        }
        return 0;
    }
    
    public long straightFlush(){
        if ((this.straight()!= 0)&&(this.flush()!= 0)){
            return (long) Math.pow(14,4)*this.straight();
        }
        return 0;
    }
    
    public long evaluate(){
        long[] hands= {this.straightFlush(), this.fOAK(), this.fullHouse(), this.flush(), this.straight(), this.set(), this.pair()};
        for (int i = 0; i < 7; i++){
            if (hands[i] != 0){
                return hands[i];
            }
        }
        for (int i = 13; i > -1; i--){
            if (cardRanks[i] != 0){
                return i;
            }
        }
        return 0;
    }
}
