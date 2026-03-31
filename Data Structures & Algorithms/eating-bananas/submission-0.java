class Solution {
    boolean validSpeed(int[] piles, int hours, int speed) {
        int totalTime = 0;
        for(int bananas : piles) {
            totalTime += bananas / speed;
            if((bananas % speed) != 0) totalTime++;
        }
        return totalTime <= hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int bananas : piles) right = Math.max(right, bananas);
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(validSpeed(piles, h, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
