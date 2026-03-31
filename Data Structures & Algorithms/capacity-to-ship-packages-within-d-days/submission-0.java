class Solution {
    boolean isValidCapacity(int[] weights, int days, int capacity) {
        int daysTaken = 1;
        int remainingCapacity = capacity;
        for(int weight : weights) {
            if(weight > capacity) return false;
            if(weight <= remainingCapacity) {
                remainingCapacity -= weight;
            }
            else {
                daysTaken++;
                remainingCapacity = capacity - weight;
            }
        }
        return daysTaken <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isValidCapacity(weights, days, mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}