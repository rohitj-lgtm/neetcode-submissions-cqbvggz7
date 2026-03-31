class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int total = 0;
        int result = Integer.MAX_VALUE;

        for(int r = 0; r < nums.length; r++){
            total += nums[r];
            while(total >= target){
                result = Math.min(result, r - l + 1);
                total -= nums[l];
                l++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}