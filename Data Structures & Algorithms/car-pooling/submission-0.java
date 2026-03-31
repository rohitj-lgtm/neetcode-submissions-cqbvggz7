class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        Queue<int[]> activeTrips = new PriorityQueue<>((a,b)->(a[2] - b[2]));
        final int PASSENGERS = 0, PICKUP = 1, DROPOFF = 2;
        int passengers = 0;

        for (int[] trip : trips) {
            passengers += trip[PASSENGERS];
            while (!activeTrips.isEmpty() && activeTrips.peek()[DROPOFF] <= trip[PICKUP]) {
                passengers -= activeTrips.poll()[PASSENGERS];
            }
            if (passengers > capacity) {
                return false;
            }
            activeTrips.offer(trip);
        }

        return true;
    }
}