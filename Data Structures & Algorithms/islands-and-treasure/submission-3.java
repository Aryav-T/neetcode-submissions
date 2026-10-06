class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int INF = 2147483647;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];
                if(grid[r][c] == INF) grid[r][c] = steps;
                for(int[] dir : DIRS){
                    int newRow = r + dir[0], newCol = c + dir[1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] != -1){
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
    }

}


















