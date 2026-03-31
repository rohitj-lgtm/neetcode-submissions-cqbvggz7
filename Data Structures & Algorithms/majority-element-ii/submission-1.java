class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int element1 = -1, element2 = -1;
        for(int num : nums){
            if(num == element1) count1++;
            else if(num == element2) count2++;
            else if(count1 == 0){
                element1 = num;
                count1++;
            }else if(count2 == 0){
                element2 = num;
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int num : nums){
            if(num == element1) count1++;
            if(num == element2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3) res.add(element1);
        if(count2 > nums.length / 3) res.add(element2);

        return res;
    }
}