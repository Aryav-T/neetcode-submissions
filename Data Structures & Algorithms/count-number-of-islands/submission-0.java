class Solution {
    int rows, cols;
    int[][] DIRS;
    public int numIslands(char[][] grid) {
        DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '2' || grid[row][col] == '0') return;

        grid[row][col] = '2';
        for(int[] dir : DIRS){
            int newR = row + dir[0], newC = col + dir[1];
            dfs(grid, newR, newC);
        }
    }
}
