class Solution {
    List<List<Integer>> result;
    List<Integer> state;
    int[] nums;

    private void dfs(int i) {
        if(i > nums.length) return;
        result.add(new ArrayList<>(state));
        for(int j = i; j < nums.length; j++) {
            if(j > i && nums[j] == nums[j - 1]) continue;
            state.add(nums[j]);
            dfs(j + 1);
            state.remove(state.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        state = new ArrayList<>();
        this.nums = nums;

        dfs(0);

        return result;
    }
}
