class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int s = 0;
        int e = heights.length - 1;
        while(s < e){
            int smaller = Math.min(heights[s], heights[e]);
            int area = (e - s) * smaller;
            result = Math.max(area, result);
            if(smaller == heights[s]) s++;
            else e--;
        }
        return result;
    }
}
