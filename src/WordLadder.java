import java.util.HashSet;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	private static int distance(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i ++)
			if (s1.charAt(i) != s2.charAt(i))
				diff ++;
		return diff;
	}

}
