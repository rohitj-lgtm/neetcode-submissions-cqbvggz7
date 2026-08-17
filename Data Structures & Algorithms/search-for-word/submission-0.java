class Solution {
    char[][] board;
    String word;

    private boolean dfs(int row, int col, int i) {
        if(i == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        boolean result = false;
        if(board[row][col] == word.charAt(i)) {
            char temp = board[row][col];
            board[row][col] = '-';
            result = dfs(row + 1, col, i + 1) ||
            dfs(row - 1, col, i + 1) ||
            dfs(row, col - 1, i + 1) ||
            dfs(row, col + 1, i + 1);
            board[row][col] = temp;
        }
        return result;

    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(dfs(row, col, 0)) return true;
            }
        }
        return false;
    }
}
