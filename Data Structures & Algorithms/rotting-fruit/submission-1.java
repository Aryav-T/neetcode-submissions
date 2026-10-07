class Solution {
    int[][] DIRS; 
    int rows, cols;
    public int orangesRotting(int[][] grid) {
        DIRS = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
        rows = grid.length;
        cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int steps = 0;
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int currR = curr[0], currC = curr[1];
                for(int[] dir : DIRS){
                   int newR = currR + dir[0], newC = currC + dir[1];
                   if(newR >= 0 && newR < rows && newC >=0 && newC < cols && grid[newR][newC] == 1){
                    grid[newR][newC] = 2;
                    fresh--;
                    queue.offer(new int[]{newR, newC});
                   }
                }
            }
            steps++;
        }
        if(fresh == 0){
            return steps;
        }
        return -1;
    }
}
