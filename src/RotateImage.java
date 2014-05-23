/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int i = 0; i < length / 2; i ++)
			for (int j = 0; j < (length + 1) / 2; j ++)
			{
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[length - 1 - j][i];
				matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
				matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
				matrix[j][length - 1 - i] = tmp;
			}
	}

}
