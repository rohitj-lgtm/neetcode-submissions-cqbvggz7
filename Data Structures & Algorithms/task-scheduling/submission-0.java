class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(char task : freqMap.keySet()) {
            maxHeap.offer(new int[]{task, freqMap.get(task)});
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int cycle = 0;

        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            cycle++;
            while(!cooldownQueue.isEmpty() && cooldownQueue.peek()[2] <= cycle) {
                int[] entry = cooldownQueue.poll();
                maxHeap.offer(new int[]{ entry[0], entry[1] });
            }

            if(!maxHeap.isEmpty()) {
                int[] entry = maxHeap.poll();
                if(entry[1] > 1) {
                    cooldownQueue.offer(new int[] { entry[0], entry[1] - 1, cycle + n + 1 });
                }
            }
        }

        return cycle;
    }
}


