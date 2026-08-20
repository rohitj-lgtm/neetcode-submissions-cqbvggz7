class Solution {
    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j>= board[0].length || board[i][j] == 'X' || board[i][j] == 'U') return;
        board[i][j] = 'U';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int i = 0; i < ROWS; i++) {
            dfs(board, i, 0);
            dfs(board, i, COLS - 1);
        }

        for(int i = 0; i < COLS; i++) {
            dfs(board, 0, i);
            dfs(board, ROWS - 1, i);
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'U') board[i][j] = 'O';
            }
        }
    }
}
