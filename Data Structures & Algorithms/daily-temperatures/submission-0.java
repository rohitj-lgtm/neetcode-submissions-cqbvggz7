class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            while((!stack.isEmpty()) && stack.peek()[0] <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
            } else{
                ans[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return ans;
    }
}
