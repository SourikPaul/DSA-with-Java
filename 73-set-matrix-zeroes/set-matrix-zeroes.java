class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == 0){
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (zeroRows[row] || zeroCols[col]){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}