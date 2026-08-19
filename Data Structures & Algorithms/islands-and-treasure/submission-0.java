class Solution {
    private static int INF = 2147483647;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void bfs(int[][] grid, Queue<int[]> queue) {
        int dist = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for(int[] d : dirs) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == INF) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(grid, queue);
    }
}
