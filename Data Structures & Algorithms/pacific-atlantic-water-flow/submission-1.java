class Solution {
    int[][] heights;
    int ROWS;
    int COLS;

    private void dfs(boolean[][] vis, int r, int c, int prevHeight) {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || vis[r][c] || prevHeight > heights[r][c]) return;

        vis[r][c] = true;
        dfs(vis, r - 1, c, heights[r][c]);
        dfs(vis, r + 1, c, heights[r][c]);
        dfs(vis, r, c - 1, heights[r][c]);
        dfs(vis, r, c + 1, heights[r][c]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.ROWS = heights.length;
        this.COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < COLS; i++) {
            dfs(pacific, 0, i, heights[0][i]);
            dfs(atlantic, ROWS - 1, i, heights[ROWS - 1][i]);
        }
        for(int i = 0; i < ROWS; i++) {
            dfs(pacific, i, 0, heights[i][0]);
            dfs(atlantic, i, COLS - 1, heights[i][COLS - 1]);
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }
}
