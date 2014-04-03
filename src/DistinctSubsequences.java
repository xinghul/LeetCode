/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("ccc", "c"));
	}
	
	public static int numDistinct(String S, String T) {
		if (T.length() > S.length())
			return 0;
		
		int[] match = new int[T.length() + 1];
		match[0] = 1;
		for (int i = 1; i <= T.length(); i ++)
			match[i] = 0;
		
		for (int i = 1; i <= S.length(); i ++)
			for (int j = T.length(); j >= 1; j --)
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					//System.out.println(i + "*" + j + "~" + match[j - 1] + "*" + match[j]);
					match[j] += match[j - 1];
				}
		return match[T.length()];
	}

}
