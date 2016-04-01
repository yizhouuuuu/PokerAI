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
public class Compare {
    public Compare(){
        
    }

    public static int compare(long a, long b){
        
        if (a > b){
            return 1;
        } else if (b > a){
            return 2;
        } else {
            return 0;
        }
    }
    
}

    
    
