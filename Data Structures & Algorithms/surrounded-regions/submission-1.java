class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length; 
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                capture(board, i, 0);
            }
            if(board[i][cols-1] == 'O'){
                capture(board, i, cols-1);
            }
        } 
        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O'){
                capture(board, 0, i);
            }
            if(board[rows-1][i] == 'O'){
                capture(board, rows-1, i);
            }
        } 
        for(int i =0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]== 's'){
                    board[i][j] = 'O';
                }
            }
        }
       
    }
    private void capture(char[][]board, int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O')  return;
    
    board[r][c] = 's';
    capture(board, r+1, c);
    capture(board, r-1, c);
    capture(board, r, c+1);
    capture(board, r, c-1);
    }
}
