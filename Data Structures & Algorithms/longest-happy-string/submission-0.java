class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            char ch = (char) first[1];
            int len = result.length();

            boolean wouldTriple = len > 1
                && result.charAt(len - 1) == ch
                && result.charAt(len - 2) == ch;

            if (wouldTriple) {
                if (maxHeap.isEmpty()) break;

                int[] second = maxHeap.poll();
                appendChar(result, maxHeap, second);
                maxHeap.offer(first);
            } else {
                appendChar(result, maxHeap, first);
            }
        }

        return result.toString();
    }

    private void appendChar(StringBuilder result, PriorityQueue<int[]> heap, int[] entry) {
        result.append((char) entry[1]);
        entry[0]--;
        if (entry[0] > 0) heap.offer(entry);
    }
}