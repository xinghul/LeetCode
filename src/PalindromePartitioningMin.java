import java.util.HashMap;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class PalindromePartitioningMin {

	/**
	 * @param args
	 */
	public int minCut(String s) {
		int length = s.length() - 1;
		int minCuts[] = new int[length + 1];
		boolean[][] isP = new boolean[length][length];
		for (int i = 0; i <= length; i ++)
			minCuts[i] = length - i;
		for (int i = length; i >= 0; i --) 
		{
			for (int j = i; j <= length; j ++) 
			{
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isP[i + 1][j - 1])) {
					isP[i][j] = true;
					minCuts[i] = Math.min(minCuts[i], minCuts[j + 1] + 1);
				}
			}
		}
		return minCuts[0];
	}
}
