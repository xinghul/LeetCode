import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(4);
		for (int i = 0; i < result.size(); i ++)
		{
			for (int j = 0; j < result.get(i).length; j ++)
			{
				System.out.println(result.get(i)[j]);
			}
			System.out.println();
		}
	}
	static ArrayList<String[]> result = new ArrayList<String[]>();
	public static ArrayList<String[]> solveNQueens(int n) {
		char[][] pos = new char[n][n];
		for (int i = 0; i < pos.length; i ++)
			for (int j = 0; j < pos.length; j ++)
				pos[i][j] = '.';
		putQueen(pos, 0);
		return result;
	}
	
	private static void putQueen(char[][] pos, int i) {
		if (i == pos.length) {
			addResult(pos);
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
	
	private static void addResult(char[][] pos) {
		String[] ans = new String[pos.length];
		for (int i = 0; i < pos.length; i ++) 
		{
			String s = "";
			for (int j = 0; j < pos[i].length; j ++)
				s += pos[i][j];
			ans[i] = s;
		}
		result.add(ans);
	}

}
