/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] pathNum = new int[m][n];
		
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		pathNum[m - 1][n - 1] = 1;
		
		for (int i = m - 2; i >= 0; i --)
		{
			if (obstacleGrid[i][n - 1] == 1)
				pathNum[i][n - 1] = 0;
			else
				pathNum[i][n - 1] = pathNum[i + 1][n - 1];
		}
		for (int i = n - 2; i >= 0; i --)
		{
			if (obstacleGrid[m - 1][i] == 1)
				pathNum[m - 1][i] = 0;
			else
				pathNum[m - 1][i] = pathNum[m - 1][i + 1];
		}

		for (int i = m - 2; i >= 0; i --)
			for (int j = n - 2; j >= 0; j --)
			{
				if (obstacleGrid[i][j] == 1)
					pathNum[i][j] = 0;
				else
					pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
			}
		return pathNum[0][0];
	}

}
