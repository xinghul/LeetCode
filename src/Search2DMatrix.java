/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i ++)
		{
			if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
				for (int j = 0; j < matrix[i].length; j ++)
					if (target == matrix[i][j])
						return true;
				return false;
			}
		}
		return false;
	}

}
