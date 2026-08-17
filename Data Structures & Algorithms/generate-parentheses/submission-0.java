class Solution {
    List<String> result;
    StringBuilder state;
    int n;
    int[] count;

    private void dfs() {
        if(count[1] > count[0] || (state.length() > 2*n)) return;
        if((state.length() == 2*n) && count[1] == count[0]) {
            result.add(state.toString());
            return;
        }

        state.append('(');
        count[0]++;
        dfs();
        count[0]--;
        state.deleteCharAt(state.length() - 1);

        state.append(')');
        count[1]++;
        dfs();
        count[1]--;
        state.deleteCharAt(state.length() - 1);

    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        state = new StringBuilder();
        this.n = n;
        count = new int[]{0, 0};

        dfs();

        return result;
    }
}