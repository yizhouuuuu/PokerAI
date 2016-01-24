package poker;
import java.util.*;

/**
 *
 * @author Max
 */
public class Compare {
    public void Compare(){
        
    }
    private static Map<Character, Integer> rank = new HashMap<Character, Integer>(){{
           put('N', -1);
           put('H', 0);
           put('P', 1);
           put('2', 2);
           put('3', 3);
           put('S', 4);
           put('F', 5);
           put('B', 6);
           put('4', 7);
           put('R', 8);
        }};
    
    public static int compare(String a, String b){
        
        if(rank.get(a.charAt(0)) > rank.get(b.charAt(0))){
            return 1;
        } else if (rank.get(a.charAt(0)) < rank.get(b.charAt(0))){
            return 2;
        } else {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++){
                if (a.charAt(i) != b.charAt(i)){
                    if (a.length() > b.length()){
                        return 1;
                    } else if (a.length() < b.length()){
                        return 2;
                    } else if (a.charAt(i) == ' '){
                        return 2;
                    } else if (b.charAt(i) == ' '){
                        return 1;
                    } else if (a.charAt(i) < b.charAt(i)){
                        return 2;
                    } else if (a.charAt(i) > b.charAt(i)){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    
    
}
