class Solution {
    public int islandPerimeter(int[][] grid) {
        int landcells = 0;
        int landpairs = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    landcells++;
                    if(i - 1 >= 0 && grid[i - 1][j] == 1) landpairs++;
                    if(i + 1 < rows && grid[i + 1][j] == 1) landpairs++;
                    if(j - 1 >= 0 && grid[i][j - 1] == 1) landpairs++;
                    if(j + 1 < cols && grid[i][j + 1] == 1) landpairs++;
                }
            }
        }

        return (4 * landcells) - landpairs;
    }
}