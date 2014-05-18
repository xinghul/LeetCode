import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(spiralOrder(matrix));
	}
	
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0)
			return result;
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		boolean[][] visited = new boolean[rowNum][colNum];
		
		int num = 1;
		int target = rowNum * colNum;
		
		int direction = 0;
		int i = 0, j = 0;
		while (num <= target)
		{
			switch (direction) 
			{
			case 0 :
				if (j < colNum && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
					num ++;
					j ++;
				}
				else {
					j --;
					i ++;
					direction = 1;
				}
				break;
			case 1 :
				if (i < rowNum && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
					num ++;
					i ++;
				}
				else {
					i --;
					j --;
					direction = 2;
				}
				break;
			case 2 :
				if (j >= 0 && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
					num ++;
					j --;
				}
				else {
					j ++;
					i --;
					direction = 3;
				}
				break;
			case 3 :
				if (i >= 0 && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
					num ++;
					i --;
				}
				else {
					i ++;
					j ++;
					direction = 0;
				}
				break;
			default :
				break;
			}
		}
		
		return result;
	}

}
