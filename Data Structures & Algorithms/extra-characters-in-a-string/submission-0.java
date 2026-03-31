class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (int k = word.length() - 1; k >= 0; k--) {   // insert reversed
                char ch = word.charAt(k);
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.isEnd = true;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;       // skip s[i-1]
            TrieNode node = root;
            for (int j = i - 1; j >= 0; j--) {   // walk backwards
                char ch = s.charAt(j);
                if (!node.children.containsKey(ch)) break;   // early exit
                node = node.children.get(ch);
                if (node.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}