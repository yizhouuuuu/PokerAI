package poker;
import java.util.*;
/**
 *
 * @author Max
 */
public class Evaluate {
    public static int[] evaluateHand(Card a, Card b){
        int[] wr = new int[3];
        Deck d = new Deck();
        d.makeDeck();
        Card[] a1 = new Card[7];
        Card[] a2 = new Card[7];
        PokerHand ph1 = new PokerHand();
        PokerHand ph2 = new PokerHand();
        String max1 = "N";
        String max2 = "N";
        ArrayList<ArrayList<Integer>> k = test.combine(7,5);
        for (int i = 0; i < 100000; i++){
            a2 = d.Deal(a, b);
            a1[0] = a;
            a1[1] = b;
            a1[2] = a2[2];
            a1[3] = a2[3];
            a1[4] = a2[4];
            a1[5] = a2[5];
            a1[6] = a2[6];
            for (int j = 0; j < 21; j++){
                ph1.setPokerHand(a1[k.get(j).get(0) - 1], a1[k.get(j).get(1) - 1], a1[k.get(j).get(2) - 1], a1[k.get(j).get(3) - 1], a1[k.get(j).get(4) - 1]);
                ph2.setPokerHand(a2[k.get(j).get(0) - 1], a2[k.get(j).get(1) - 1], a2[k.get(j).get(2) - 1], a2[k.get(j).get(3) - 1], a2[k.get(j).get(4) - 1]);
                ph1.countCards();
                ph2.countCards();
                if (Compare.compare(ph1.evaluate(), max1) == 1){
                    max1 = ph1.evaluate();
                }
                if (Compare.compare(ph2.evaluate(), max2) == 1){
                    max2 = ph2.evaluate();
                }
                ph1.resetCount();
                ph2.resetCount();
            }
            wr[Compare.compare(max1, max2)]++;
            max1 = "N";
            max2 = "N";
        }
        return wr;
    }
}
