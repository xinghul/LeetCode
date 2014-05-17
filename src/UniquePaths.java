/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int rowNum, colNum;
	public int uniquePathsRecursive(int m, int n) {
		rowNum = m;
		colNum = n;
		if (m < 1 || n < 1)
			return 0;
		return pathNum(1, 1);
	}
	
	private int pathNum(int i, int j) {
		if (i == rowNum || j == colNum)
			return 1;
		return pathNum(i + 1, j) + pathNum(i, j + 1);
	}
	
	public int uniquePaths(int m, int n) {
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i ++)
			pathNum[i][n - 1] = 1;
		for (int i = 0; i < n; i ++)
			pathNum[m - 1][i] = 1;
		
		for (int i = m - 2; i >= 0; i --)
			for (int j = n - 2; j >= 0; j --)
				pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
		return pathNum[0][0];
	}

}
