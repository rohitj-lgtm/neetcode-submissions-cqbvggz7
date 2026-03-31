class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);
        for(int num : nums){
            sum += num;
            result += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}