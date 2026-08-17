class Solution {
    List<List<Integer>> result;
    List<Integer> state;
    int[] nums;
    Set<Integer> vis;

    private void dfs(int i) {
        if(i == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }

        for(int j = 0; j < nums.length; j++) {
            if(j > 0 && nums[j] == nums[j - 1] && !vis.contains(j-1)) continue;
            if(vis.contains(j)) continue;
            state.add(nums[j]);
            vis.add(j);
            dfs(i + 1);
            vis.remove(j);
            state.remove(state.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        state = new ArrayList<>();
        vis = new HashSet<>();
        this.nums = nums;
        Arrays.sort(nums);

        dfs(0);

        return result;
    }
}