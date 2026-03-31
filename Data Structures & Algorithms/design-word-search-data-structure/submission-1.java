class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode current = root;
        for(int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode node : current.children) {
                    if(node != null && dfs(word, i + 1, node)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(current.children[c - 'a'] == null) {
                    return false;
                }
                current = current.children[c - 'a'];
            }
        }
        return current.isWord;
    }
}
