/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minPathSum(int[][] grid) {
		if (grid.length == 0)
			return 0;
		
		int rowNum = grid.length;
		int colNum = grid[0].length;
		int[][] cost = new int[rowNum][colNum];
		
		cost[rowNum - 1][colNum - 1] = grid[rowNum - 1][colNum - 1];
		for (int i = colNum - 2; i >= 0; i --)
			cost[rowNum - 1][i] = cost[rowNum - 1][i + 1] + grid[rowNum - 1][i];
		for (int i = rowNum - 2; i >= 0; i --)
			cost[i][colNum - 1] = cost[i + 1][colNum - 1] + grid[i][colNum - 1];
		
		for (int i = grid.length - 2; i >= 0; i --)
			for (int j = grid[0].length - 2; j >= 0; j --)
				cost[i][j] = grid[i][j] + Math.min(cost[i + 1][j], cost[i][j + 1]);
		
		return cost[0][0];
	}

}
