class Solution {
    int rows;
    int cols;
    private static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private void bfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] node = queue.poll();
                for (int[] d : dirs) {
                    int nr = node[0] + d[0], nc = node[1] + d[1];
                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == '1') {
                        grid[nr][nc] = '0';
                        queue.offer(new int[]{nr, nc});
                    }                    
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }

        return islands;
    }
}
