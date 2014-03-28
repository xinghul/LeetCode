import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IsPalindrome("a"));
		System.out.println(IsPalindrome("aa"));
		System.out.println(IsPalindrome("ab"));
		System.out.println(IsPalindrome("aabaa"));
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		return null;
	}
	
	private static boolean IsPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i ++) 
		{
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

}
