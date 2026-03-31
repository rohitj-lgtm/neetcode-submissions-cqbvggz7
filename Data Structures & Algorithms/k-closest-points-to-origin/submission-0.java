class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (
            ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1]))
        ));
        for(int[] point : points) {
            minHeap.offer(point);
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
