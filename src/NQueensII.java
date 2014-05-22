
/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class NQueensII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		totalNQueens(4);
		System.out.println(count);
	}
	static int count = 0;
	public static int totalNQueens(int n) {
		char[][] pos = new char[n][n];
		for (int i = 0; i < pos.length; i ++)
			for (int j = 0; j < pos.length; j ++)
				pos[i][j] = '.';
		putQueen(pos, 0);
		return count;
	}
	
	private static void putQueen(char[][] pos, int i) {
		if (i == pos.length) {
			count ++;
			return;
		}
		for (int j = 0; j < pos[i].length; j ++)
		{
			if (canFit(pos, i, j)) {
				pos[i][j] = 'Q';
				putQueen(pos, i + 1);
				pos[i][j] = '.';
			}
		}
	}
	
	private static boolean canFit(char[][] pos, int i, int j) {
		for (int k = 0; k < pos.length; k ++)
			if (pos[k][j] == 'Q')
				return false;
		for (int k = 0; k < pos.length; k ++)
			if (pos[i][k] == 'Q')
				return false;
		
		int ii = i, jj = j;
		while (ii >= 0 && jj >= 0)
			if (pos[ii --][jj --] == 'Q')
				return false;
		ii = i;
		jj =j;
		while (ii < pos.length && jj < pos.length)
			if (pos[ii ++][jj ++] == 'Q')
				return false;
		
		ii = i;
		jj =j;
		while (ii < pos.length && jj >= 0)
			if (pos[ii ++][jj --] == 'Q')
				return false;
		ii = i;
		jj =j;
		while (ii >= 0 && jj < pos.length)
			if (pos[ii --][jj ++] == 'Q')
				return false;
		return true;
	}
}
