class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> m = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            if(m.containsKey(s.charAt(r))) l = Math.max(m.get(s.charAt(r)) + 1, l);
            m.put(s.charAt(r), r);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
