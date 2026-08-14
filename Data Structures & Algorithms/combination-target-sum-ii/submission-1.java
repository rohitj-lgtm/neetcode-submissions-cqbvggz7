class Solution {
    List<Integer> path;
    List<List<Integer>> result;
    int[] candidates;

    private void dfs(int start, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            if(i > start && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;

        dfs(0, target);

        return result;
    }
}