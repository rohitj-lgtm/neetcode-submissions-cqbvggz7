class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    private TrieNode prefixSearch(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    public boolean search(String word) {
        TrieNode prefix = prefixSearch(word);
        return prefix != null && prefix.isEnd;
    }

    public boolean startsWith(String prefix) {
        return prefixSearch(prefix) != null;
    }
}
