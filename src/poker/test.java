package poker;
import java.util.ArrayList;
/**
 *
 * @author Max
 */
public class test {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
	//illegal case
	if (k > n) {
		return null;
	//if k==n
	} else if (k == n) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			temp.add(i);
		}
		result.add(temp);
		return result;
	//if k==1
	} else if (k == 1) {
 
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			result.add(temp);
		}
 
		return result;
	}
 
	//for normal cases, initialize a list with one element
	for (int i = 1; i <= n - k + 1; i++) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(i);
		result.add(temp);
	}
 
	//recursively add more elements
	combine(n, k, result);
 
	return result;
}
 
public static void combine(int n, int k, ArrayList<ArrayList<Integer>> result) {
	ArrayList<ArrayList<Integer>> prevResult = new ArrayList<ArrayList<Integer>>();
	prevResult.addAll(result);
 
	if(result.get(0).size() == k) return;
 
	result.clear();
	for (ArrayList<Integer> one : prevResult) {
 
		for (int i = 1; i <= n; i++) {
			if (i > one.get(one.size() - 1)) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(one);
				temp.add(i);
				result.add(temp);
			}
		}
	}
 
	combine(n, k, result);
}
}
