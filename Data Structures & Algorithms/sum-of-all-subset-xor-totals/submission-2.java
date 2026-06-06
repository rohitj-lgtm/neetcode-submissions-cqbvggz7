class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset) {
        int xorr = 0;
        for(int num : subset) xorr ^= num;
        res += xorr;

        for(int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(nums, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}