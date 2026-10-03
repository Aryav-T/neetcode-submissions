class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean[] rowZero = new boolean[rows];
        boolean[] colsZero = new boolean[cols];

        for(int r =0;  r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] == 0){
                    rowZero[r] = true;
                    colsZero[c] = true;
                }
            }
        }
        for(int r =0;  r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(rowZero[r] || colsZero[c]){
                     matrix[r][c] =0;
                }
            }
        }


    }
}
