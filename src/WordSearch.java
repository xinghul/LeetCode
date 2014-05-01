/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
		System.out.println(exist(board, "AAB"));
	}
	
	private static int row;
	private static int col;
    public static boolean exist(char[][] board, String word) {
		row = board.length;
		col = board[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, word, 0, i, j, visited))
					return true;
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, String word, int index, int rowindex,
			int colindex, boolean[][] visited) {
		if (index == word.length())
			return true;
		if (rowindex < 0 || colindex < 0 || rowindex >= row || colindex >= col)
			return false;
		if (visited[rowindex][colindex])
			return false;
		if (board[rowindex][colindex] != word.charAt(index))
			return false;
		visited[rowindex][colindex] = true;
		boolean res = dfs(board, word, index + 1, rowindex - 1, colindex,
				visited)
				|| dfs(board, word, index + 1, rowindex + 1, colindex, visited)
				|| dfs(board, word, index + 1, rowindex, colindex + 1, visited)
				|| dfs(board, word, index + 1, rowindex, colindex - 1, visited);
		visited[rowindex][colindex] = false;
		return res;
	}
	
}
