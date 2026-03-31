class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for(int i : nums) {
            if(i == 0) {
                red++;
            } else if(i == 1) {
                white++;
            } else {
                blue++;
            }
        }
        int count = 0;
        for(int i = 0; i < red; i++) {
            nums[count++] = 0;
        }
        for(int i = 0; i < white; i++) {
            nums[count++] = 1;
        }
        for(int i = 0; i < blue; i++) {
            nums[count++] = 2;
        }
    }
}