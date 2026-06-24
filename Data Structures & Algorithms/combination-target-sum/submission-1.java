class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int i, int[] nums, int target, List<Integer> current) {
        if(i >= nums.length || target < 0) {
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        backtrack(i, nums, target - nums[i], current);
        current.remove(current.size() - 1);
        backtrack(i + 1, nums, target, current);
    }
}
