/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateMatrix(4);
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int num = 1;
		int target = n * n;
		
		int direction = 0;
		int i = 0, j = 0;
		while (num <= target)
		{
			switch (direction) 
			{
			case 0 :
				if (j < n && matrix[i][j] == 0)
					matrix[i][j ++] = num ++;
				else {
					j --;
					i ++;
					direction = 1;
				}
				break;
			case 1 :
				if (i < n && matrix[i][j] == 0)
					matrix[i ++][j] = num ++;
				else {
					i --;
					j --;
					direction = 2;
				}
				break;
			case 2 :
				if (j >= 0 && matrix[i][j] == 0)
					matrix[i][j --] = num ++;
				else {
					j ++;
					i --;
					direction = 3;
				}
				break;
			case 3 :
				if (i >= 0 && matrix[i][j] == 0)
					matrix[i --][j] = num ++;
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
		
		for(i = 0; i < n; i ++)
		{
			for (j = 0; j < n; j ++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

}
