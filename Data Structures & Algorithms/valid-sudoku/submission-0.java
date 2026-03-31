class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for(int i = 0; i < 9; i++){
            Set<Character> s = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(s.contains(board[i][j])) return false;
                    s.add(board[i][j]);
                }
            }
        }
        // validate cols
        for(int i = 0; i < 9; i++){
            Set<Character> s = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(s.contains(board[j][i])) return false;
                    s.add(board[j][i]);
                }
            }
        }
        // validate boxes
        for(int r = 3; r <= 9; r+=3){
            for(int c = 3; c <= 9; c+=3){
                Set<Character> s = new HashSet<>();
                for(int i = r - 3; i < r; i++){
                    for(int j = c - 3; j < c; j++){
                        if(board[j][i] != '.'){
                            if(s.contains(board[j][i])) return false;
                            s.add(board[j][i]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
