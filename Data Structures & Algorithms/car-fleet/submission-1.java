class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // create pairs
        int[][] positionSpeedPairs = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            positionSpeedPairs[i][0] = position[i];
            positionSpeedPairs[i][1] = speed[i];
        }

        // sort decreasing by position
        Arrays.sort(positionSpeedPairs, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        float prevTime = 0;
        for(int[] pair : positionSpeedPairs){
            float currentTime = (float)(target - pair[0]) / pair[1];
            if(currentTime > prevTime){
                fleets++;
                prevTime = currentTime;
            }
        }

        return fleets;
    }
}
