class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, 0, cur);
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList(cur));
            return;
        } else if(target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], i, cur);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, i + 1, cur);
        return;
    }
}