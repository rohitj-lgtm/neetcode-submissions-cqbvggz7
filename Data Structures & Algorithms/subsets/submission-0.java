class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, subset, result);

        return result;

    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        //include nums[i]
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, result);
        //backtrack
        subset.remove(subset.size() - 1);
        // exclude
        dfs(nums, i + 1, subset, result);
    }
}
