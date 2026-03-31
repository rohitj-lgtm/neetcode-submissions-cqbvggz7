class MinStack {
    Stack<Long> stk;
    long min;

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(0L);
            min = val;
        } else {
            stk.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) return;
        long pop = stk.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        long top = stk.peek();
        if(top > 0) return (int) (top + min);
        else return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
