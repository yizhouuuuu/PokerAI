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
public class Poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card a = new Card(7,1);
        Card b = new Card(3,0);
        
        System.out.print(Arrays.toString(Evaluate.evaluateHand(a, b)));
        System.out.print("hello");
    }
    
}
