class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset){
        int xor_result = 0;
        for(int num : subset) xor_result ^= num;
        res += xor_result;

        for( int j = i; j < nums.length; j++){
            subset.add(nums[j]);
            backtrack(j + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}