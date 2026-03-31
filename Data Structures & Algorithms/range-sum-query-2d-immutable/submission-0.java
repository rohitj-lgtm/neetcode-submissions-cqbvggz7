class NumMatrix {

    int[][] rangeSum;
    public NumMatrix(int[][] matrix) {
        rangeSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++){
            int prefix=0;
            for(int j = 0; j < matrix[0].length; j++){
                prefix += matrix[i][j];
                int above = rangeSum[i][j+1];
                rangeSum[i+1][j+1] = prefix+above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int br = rangeSum[row2+1][col2+1];
        int bl = rangeSum[row2+1][col1];
        int tr = rangeSum[row1][col2+1];
        int tl = rangeSum[row1][col1];
        return br - bl - tr + tl;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */