class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            maxHeap.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        while (!maxHeap.isEmpty() || prev != ' ') {
            if(maxHeap.isEmpty() && prev != ' ') return "";

            char curr = maxHeap.poll();
            sb.append(curr);
            map.put(curr, map.get(curr) - 1);

            if(prev != ' ') {
                maxHeap.offer(prev);
                prev = ' ';
            }

            if(map.get(curr) > 0) {
                prev = curr;
            }
        }

        return sb.toString();
    }
}