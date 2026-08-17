class Solution {
    List<String> result;
    StringBuilder state;
    int n;

    private void dfs(int open, int close) {
        if(state.length() == 2*n) {
            result.add(state.toString());
            return;
        }

        if(open < n) {
            state.append('(');
            dfs(open + 1, close);
            state.deleteCharAt(state.length() - 1);
        }

        if(close < open) {
            state.append(')');
            dfs(open, close + 1);
            state.deleteCharAt(state.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        state = new StringBuilder();
        this.n = n;

        dfs(0, 0);

        return result;
    }
}