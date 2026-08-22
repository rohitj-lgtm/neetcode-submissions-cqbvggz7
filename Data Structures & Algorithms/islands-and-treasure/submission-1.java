class Solution {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean inBound(int r, int c, int[][] grid) {
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length)
            return true;
        return false;
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int dist = 1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                if(grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                for(int[] d : DIRS) {
                    int nr = node[0] + d[0], nc = node[1] + d[1];
                    if(inBound(nr, nc, grid) && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = dist;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
    }
}
