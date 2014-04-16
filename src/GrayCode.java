import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class GrayCode {

	/**
	 * @param args
	 */
	static Map<Integer, ArrayList<Integer>> sequence = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(3));
	}
	
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		if (sequence.containsKey(n))
			return sequence.get(n);
		else if (n == 1) {
			seq.add(0);
			seq.add(1);
			sequence.put(1, seq);
			return seq;
		}
		else if (n == 0) {
			seq.add(0);
			sequence.put(0, seq);
			return seq;
		}
		ArrayList<Integer> subSeq = grayCode(n - 1);
		for (int i = 0; i < subSeq.size(); i ++)
			seq.add(subSeq.get(i));
		for (int i = subSeq.size() - 1; i >= 0; i --)
			seq.add((1<<(n-1)) + subSeq.get(i));
		sequence.put(n, seq);
		return seq;
	}
	

}
