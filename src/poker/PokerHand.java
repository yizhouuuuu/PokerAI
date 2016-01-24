package poker;

/**
 *
 * @author Max
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
    
    
    public String pair(){
        int[] pairs = {-1, -1};
        int n = 0;
        for (int i = 1; i < 14; i++){
            if (cardRanks[i] == 2){
                pairs[n] = i;
                n++;
            }
        }
        if (pairs[0] == 0){
            pairs[0] = 13;
        }
        if (pairs[1]!=-1){
            
            return "2" + pairs[0] + " " + pairs[1];
        } else if(pairs[0]!=-1){
            return "P" + pairs[0];
        } else{
            return "N";
        }
    }
    
    public String set(){
        for (int i = 1; i < 14; i++){
            if (cardRanks[i] == 3){
                if (i == 0){
                    return "3" + 13;
                } else {
                return "3" + i;
                }
            }
        }
        return "N";
    }
    
    public String fOAK(){
        for (int i = 1; i < 14; i++){
            if (cardRanks[i] == 4){
                if (i == 0){
                    return "4" + 13;
                } else {
                return "4" + i;
                }
            }
        }
        return "N";
    }
    
    public String fullHouse(){
        if ((this.pair().charAt(0) == 'P')&&(this.set().charAt(0) == '3')){
            return "B" + this.pair().charAt(1) + " "+ this.set().charAt(1);
        }
        return "N";
    }
    
    public String straight(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 5; j++){
                if (cardRanks[i+j] == 1){
                    if (j == 4) {
                        return "S" + (i + j);
                    }
                } else {
                    break;
                }
            }
        }
        return "N";
    }
    
    public String flush(){
        for (int i = 0; i < 4; i++){
            if (suites[i] == 5){
                return "F" + hand[0].getRank() + " " + hand[1].getRank() + " " + hand[2].getRank() + " " +hand[3].getRank() + " " + hand[4].getRank();
            }
        }
        return "N";
    }
    
    public String straightFlush(){
        if ((this.straight().charAt(0) == 'S')&&(this.flush().charAt(0) == 'F')){
            return "R" + this.straight().charAt(1);
        }
        return "N";
    }
    
    public String evaluate(){
        String[] hands= {this.straightFlush(), this.fOAK(), this.fullHouse(), this.flush(), this.straight(), this.set(), this.pair()};
        for (int i = 0; i < 7; i++){
            if (hands[i].charAt(0)!='N'){
                return hands[i];
            }
        }
        for (int i = 13; i > -1; i--){
            if (cardRanks[i] != 0){
                return "H" + i;
            }
        }
        return null;
    }
}
