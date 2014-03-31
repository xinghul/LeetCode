public class SurroundedRegions {
	int rowNum;
	int colNum;
    public void solve(char[][] board) {
        rowNum = board == null ? 0 : board.length;
        colNum = rowNum == 0 ? 0 : board[0].length;
        boolean changed = false;
        do {
            changed = false;
            for(int i = 0; i < rowNum; i ++)
            {
                for(int j = 0; j < colNum; j ++)
                {
                    if (board[i][j] == 'O' && (isBorder(i, j) || isNextToDollar(board, i, j))) {
                        board[i][j] = '$';
                        changed = true;
                    }
                }
            }
        } while (changed);

        for(int i = 0; i < rowNum; i ++)
        {
            for(int j = 0; j < colNum; j ++)
            {
                board[i][j] = board[i][j] == '$' ? 'O' : 'X';
            }
        }
    }
    private boolean isBorder(int i, int j) {
        if(i == 0 || j == 0 || i == rowNum - 1 || j == colNum - 1) 
        	return true;
        return false;
    }
    private boolean isNextToDollar(char[][] board, int i, int j) {
        int x, y;
        
        x = i-1; 
        y=j;
        if(x>=0 && x<=rowNum-1 && y>=0 && y<=colNum-1 && board[x][y]=='$') 
        	return true;
        
        x = i+1; 
        y=j;
        if(x>=0 && x<=rowNum-1 && y>=0 && y<=colNum-1 && board[x][y]=='$') 
        	return true;
        
        x = i; 
        y = j-1;
        if(x>=0 && x<=rowNum-1 && y>=0 && y<=colNum-1 && board[x][y]=='$') 
        	return true;
        
        x = i; 
        y = j+1;
        if(x>=0 && x<=rowNum-1 && y>=0 && y<=colNum-1 && board[x][y]=='$') 
        	return true;
        
        return false;
    }
}