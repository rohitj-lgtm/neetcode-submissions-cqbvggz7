class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(1, n, k, result, path);
        return result;
    }

    private void dfs(int i, int n, int k,List<List<Integer>> result, List<Integer> path) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j<=n; j++){
            path.add(j);
            dfs(j + 1, n, k, result, path);
            path.remove(path.size() - 1);
        }
    }
}