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
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        grid[r][c] = '2';
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: DIRS){
                int newR = curr[0] + dir[0];
                int newC = curr[1] + dir[1];
                if(newR >=0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] != '2' && grid[newR][newC] != '0'){
                    grid[newR][newC] = '2';
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
    }
    
}
