class Solution {
    int rows;
    int cols;
    char[][] grid;
    private void dfs(int i, int j) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        int islands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(i,j);// or bfs(i,j);
                }
            }
        }

        return islands;
    }
}
