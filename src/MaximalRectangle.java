/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] c = {{'1', '1', '0'}, {'1', '1', '0'}, {'0', '0', '0'}};
		System.out.println(maximalRectangle(c));
		//System.out.println(getSubArea(c, 0, 0));
	}
	
	public static int maximalRectangle(char[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i ++)
			for (int j = 0; j < matrix[i].length; j ++)
			{
				if ((matrix.length - i + 1) * (matrix[i].length - j) < max)
					continue;
				if (matrix[i][j] == '1') {
					int area = getSubArea(matrix, i, j);
					if (area > max)
						max = area;
				}
			}
		
		return max;
	}
	
	private static int getSubArea(char[][] matrix, int row, int col) {
		int area = 0;
		int minLength = Integer.MAX_VALUE;
		for (int i = row; i < matrix.length && matrix[i][col] == '1'; i ++)
		{
			int length = 0;
			int j = col;
			while (j < matrix[i].length && matrix[i][j] == '1')
			{
				length ++;
				j ++;
			}
			if (minLength > length)
				minLength = length;
			int tmpArea = (i - row + 1) * minLength;
			if (tmpArea > area)
				area = tmpArea;
		}
		return area;
	}

}
