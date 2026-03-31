// nums=[3,4,5,6,1,2]
// target=1

// answer: 4


class Solution {
    int findPivot(int[] nums) {
        int low = 0;
        int up = nums.length - 1;
        while(low < up) {
            int mid = low + (up - low) / 2;
            if(nums[mid] > nums[up]) {
                low = mid + 1;
            } else {
                up = mid;
            }
        }
        return low;
    }
    
    int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int pivot = findPivot(nums);
        
        // Search left part [0, pivot-1] if pivot > 0
        if (pivot > 0) {
            int res = binarySearch(nums, target, 0, pivot - 1);
            if(res != -1) return res;
        }
        
        // Search right part [pivot, length-1]
        return binarySearch(nums, target, pivot, nums.length - 1);
    }
}
