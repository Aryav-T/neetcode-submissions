class Solution {
    int[][] DIRS;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        DIRS = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                   max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();
        grid[r][c] = -1;
        queue.offer(new int[]{r,c});
        int area = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cR = curr[0], cC = curr[1];
            area++;
            for(int[] dir : DIRS){
                    int nR = cR + dir[0], nC = cC + dir[1];
                    if(nR >= 0 && nR < rows && nC >= 0 && nC < cols && grid[nR][nC] != 0 && grid[nR][nC] != -1) {
                        grid[nR][nC] = -1;
                        queue.offer(new int[]{nR, nC});
                    }
                }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) return 0;
        grid[r][c] = -1;
        return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
}
