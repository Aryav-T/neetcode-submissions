class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> block = new HashSet<>();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.' && rows.contains(board[i][j])){
                    return false;
                }
                rows.add(board[i][j]);
                if(board[j][i] != '.' && cols.contains(board[j][i])){
                    return false;
                }
                cols.add(board[j][i]);
                int row = (i/3)*3 + (j/3);
                int col = (i%3)*3 + (j%3);
                if(board[row][col] != '.' && block.contains(board[row][col])){
                    return false;
                }
                block.add(board[row][col]);
            }
        }
        return true;
    }
}