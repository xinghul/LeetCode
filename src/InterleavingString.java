/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i <= s1.length(); i ++)
			for (int j = 0; j <= s2.length(); j ++) 
			{
				if (i == 0 && j == 0)
					match[i][j] = true;
				else if (i == 0) {
					if (s2.charAt(j - 1) == s3.charAt(j - 1))
						match[i][j] = match[i][j - 1];
				}
				else if (j == 0) {
					if (s1.charAt(i - 1) == s3.charAt(i - 1))
						match[i][j] = match[i - 1][j];
				}
				else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
					match[i][j] = match[i - 1][j];
				}
				else if (s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					match[i][j] = match[i][j - 1];
				}
				else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					match[i][j] = match[i - 1][j] || match[i][j - 1];
				}
			}
		return match[s1.length()][s2.length()];
	}
	
}
