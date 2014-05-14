import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 0}};
		setZeroes(matrix);
	}
	
	public static void setZeroes(int[][] matrix) {
		if (matrix.length == 0)
			return;
		ArrayList<Integer> zeroIndex = new ArrayList<Integer>();
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		for (int i = 0; i < rowNum; i ++)
			for (int j = 0; j < colNum; j ++)
				if (matrix[i][j] == 0)
					zeroIndex.add(i * colNum + j);
		for (int i = 0; i < zeroIndex.size(); i ++)
		{
			int index = zeroIndex.get(i);
			int row = index / colNum;
			int col = index % colNum;

			int j = 0;
			while (j < rowNum)
				matrix[j ++][col] = 0;
			
			j = 0;
			while (j < colNum)
				matrix[row][j ++] = 0;
		}
	}

}
