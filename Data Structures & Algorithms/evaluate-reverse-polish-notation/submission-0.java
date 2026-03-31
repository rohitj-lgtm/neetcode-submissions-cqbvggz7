class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = stk.pop();
                int b = stk.pop();
                int c = b + a;
                stk.push(c);
            } else if(s.equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                int c = b - a;
                stk.push(c);
            } else if(s.equals("*")){
                int a = stk.pop();
                int b = stk.pop();
                int c = b * a;
                stk.push(c);
            } else if(s.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                int c = b / a;
                stk.push(c);
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}
