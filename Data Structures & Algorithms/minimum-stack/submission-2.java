class MinStack {
    Stack<Integer> stk;
    Stack<Integer> stk2;
    public MinStack() {
        stk = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(stk2.isEmpty()){
            stk2.push(val);
            return;
        }
        stk2.push(Math.min(val, stk2.peek()));
    }
    
    public void pop() {
        if(stk.isEmpty()) return;

        stk.pop();
        stk2.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}
