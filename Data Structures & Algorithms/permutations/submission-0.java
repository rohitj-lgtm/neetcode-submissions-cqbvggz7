class Solution {
    Set<Integer> visited;
    int[] nums;
    List<Integer> state;
    List<List<Integer>> result;

    private void dfs(int i) {
        if(i == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(!visited.contains(nums[j])) {
                state.add(nums[j]);
                visited.add(nums[j]);
                dfs(i + 1);
                visited.remove(nums[j]);
                state.remove(state.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.visited = new HashSet<>();
        this.nums = nums;
        this.state = new ArrayList<>();
        this.result = new ArrayList<>();

        dfs(0);

        return result;

    }
}
