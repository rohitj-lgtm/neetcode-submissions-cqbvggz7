class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int[0][2];
        }
        k = Math.min(k, points.length);

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            long dA = (long) a[0] * a[0] + (long) a[1] * a[1];
            long dB = (long) b[0] * b[0] + (long) b[1] * b[1];
            return Long.compare(dA, dB);
        });
        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
