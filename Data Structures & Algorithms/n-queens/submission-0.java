class Solution {
    List<Integer> path;
    List<List<String>> result;
    Set<Integer> usedColumn;
    Set<Integer> diag1;
    Set<Integer> diag2;
    int size;

    private void buildResult() {
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++) {
                if(j == path.get(i)) sb.append('Q');
                else sb.append('.');
            }
            temp.add(sb.toString());
        }
        result.add(temp);
    }

    private void dfs(int i) {
        if(i == size) {
            buildResult();
            return;
        }

        for(int j = 0; j < size; j++){
            if(usedColumn.contains(j)
                || diag1.contains(i + j)
                || diag2.contains(i - j)) {
                continue;
            }
            usedColumn.add(j); diag1.add(i + j); diag2.add(i - j);
            path.add(i, j);

            dfs(i + 1);

            diag2.remove(i - j); diag1.remove(i + j); usedColumn.remove(j);
        }

    }
    public List<List<String>> solveNQueens(int n) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        usedColumn = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        size = n;

        dfs(0);

        return result;
    }
}
