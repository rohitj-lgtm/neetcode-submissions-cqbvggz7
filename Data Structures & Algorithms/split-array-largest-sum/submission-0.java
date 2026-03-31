class Solution {
    boolean canSplit(int[] nums, int largest, int k){
        int splits = 1;
        int sum = 0;
        for(int n : nums){
            if(sum + n <= largest) {
                sum += n;
            } else {
                sum = n;
                splits++;
            }

            if(splits > k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for(int n : nums) {
            l = Math.max(l, n);
            r += n;
        }

        while(l < r){
            int m = l + (r - l) / 2;
            if(canSplit(nums, m, k)){
                r = m;
            } else l = m + 1;
        }

        return l;
    }
}