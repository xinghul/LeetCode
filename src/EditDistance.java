import java.util.HashMap;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("INTENTION", "EXECUTION"));
	}
	static String m, n;
	static HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
	public static int minDistanceRecursive(String word1, String word2) {
		m = word1;
		n = word2;
		return getDistance(m.length(), n.length());
	}
	
	private static int getDistance(int i, int j) {
		int index = i * n.length() + j;
		if (distance.containsKey(index))
			return distance.get(index);
		if (i == 0) {
			distance.put(index, j);
			return j;
		}
		if (j == 0) {
			distance.put(index, i);
			return i;
		}
		int Rcost = getDistance(i - 1, j - 1) + (m.charAt(i - 1) == n.charAt(j - 1) ? 0 : 1);
		int min = Math.min(Rcost, Math.min(getDistance(i, j - 1) + 1, getDistance(i - 1, j) + 1));
		distance.put(index, min);
		return min;
	}
	
	public static int minDistance(String word1, String word2) {
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 1; i <= word1.length(); i ++) 
			distance[i][0] = i;
		for (int j = 1; j <= word2.length(); j ++)
			distance[0][j] = j;
		for (int i = 1; i <= word1.length(); i ++)
			for (int j = 1; j <= word2.length(); j ++)
			{
				int Rcost = distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
				distance[i][j] = Math.min(Rcost, Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1));
			}
		return distance[word1.length()][word2.length()];
	}

}
