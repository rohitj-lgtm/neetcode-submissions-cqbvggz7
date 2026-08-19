class Solution {
    private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) {
                    boolean cant_touch_me = true;
                    for(int[] d : DIRS) {
                        int nr = i + d[0], nc = j + d[1];
                        if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] != 0) {
                            cant_touch_me = false;
                        }
                    }
                    if(cant_touch_me) return -1;
                }
            }
        }

        int time = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for(int[] d : DIRS) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 3;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        if(time == -1) time++;
        return time;
    }
}
