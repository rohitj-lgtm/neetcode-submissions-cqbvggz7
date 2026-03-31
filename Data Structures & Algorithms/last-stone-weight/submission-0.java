class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n : stones) maxHeap.offer(n);
        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x != y) maxHeap.offer(Math.abs(x - y));
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
