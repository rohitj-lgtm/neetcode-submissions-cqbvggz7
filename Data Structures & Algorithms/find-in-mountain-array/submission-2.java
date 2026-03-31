/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            int k = mountainArr.get(m);
            int kr = mountainArr.get(m + 1);
            if(k < kr){
                l = m + 1;
            } else {
                r = m;
            }
        }
        int peak = l;

        l = 0;
        r = peak;
        while(l <= r){
            int m = l + (r - l) / 2;
            int k = mountainArr.get(m);
            if(k == target) return m;
            else if(k < target) l = m + 1;
            else r = m - 1;
        }
        
        if(peak < n - 1){
            l = peak + 1;
            r = n - 1;
            while(l <= r){
                int m = l + (r - l) / 2;
                int k = mountainArr.get(m);
                if(k == target) return m;
                else if(k > target) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}