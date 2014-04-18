import java.util.Arrays;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("abc", "bca"));
	}
	
	public static boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		int length = s1.length();
		if (length == 0)
			return true;
		if (!sameChars(s1, s2))
			return false;
		for (int i = 1; i < length; i ++)
		{
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
				isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(length - i)) && 
				isScramble(s1.substring(i), s2.substring(0, length - i)))
				return true;
		}
		return false;
	}
	
	private static boolean sameChars(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}

}
