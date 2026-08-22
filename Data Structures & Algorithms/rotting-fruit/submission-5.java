class Solution {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean inBound(int r, int c, int[][] grid) {
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length)
            return true;
        return false;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int time = -1;
        int fresh = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for(int[] d : DIRS) {
                    int nr = node[0] + d[0], nc = node[1] + d[1];
                    if(inBound(nr, nc, grid) && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return (fresh == 0) ? Math.max(time, 0) : -1;

    }
}
