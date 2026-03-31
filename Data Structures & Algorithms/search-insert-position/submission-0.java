class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target < nums[0]) return 0;
        if(target > nums[n-1]) return n;
        int l = 0;
        int r = n - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target || (nums[mid] > target && nums[mid - 1] < target)) {
                return mid;
            } else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}