class Solution {
    public int islandPerimeter(int[][] grid) {
        int landcells = 0;
        int landpairs = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};   // up, down, left, right
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    landcells++;
                    for (int[] d : dirs) {
                        int nr = i + d[0], nc = j + d[1];
                        if(nr >= 0 && nc >=0 && nr < rows && nc < cols && grid[nr][nc] == 1) landpairs++;
                    }
                }
            }
        }

        return (4 * landcells) - landpairs;
    }
}