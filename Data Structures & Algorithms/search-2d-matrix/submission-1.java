class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int t = 0;
        int b = ROWS - 1;
        while(t <= b) {
            int row = (t + b)/2;
            if(target > matrix[row][COLS - 1]) t = row + 1;
            else if(target < matrix[row][0]) b = row - 1;
            else break;
        }

        if(t > b) return false;

        int row = (t + b) / 2;
        int l = 0;
        int r = COLS - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(target > matrix[row][mid]) l = mid + 1;
            else if(target < matrix[row][mid]) r = mid - 1;
            else return true;
        }
        return false;
    }
}
