class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            if(!s.add(n)) return true;
        }
        return false;
    }
}