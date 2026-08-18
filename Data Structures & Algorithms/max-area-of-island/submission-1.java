class Solution {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int bfs(int[][] grid, int i, int j) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            area++;
            for(int[] d : dirs) {
                int r  = node[0] + d[0], c = node[1] + d[1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                    grid[r][c] = 0;
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    result = Math.max(result, bfs(grid, i, j));
                }
            }
        }

        return result;
    }
}
