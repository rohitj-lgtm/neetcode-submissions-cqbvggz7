class MinStack {
    Stack<Integer> stk;
    Stack<Integer> stk2;
    public MinStack() {
        stk = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int val) {
        if(stk2.isEmpty() || val <= stk2.peek()){
            stk2.push(val);
        }

        stk.push(val);
    }
    
    public void pop() {
        if(stk.isEmpty()) return;

        int top = stk.pop();
        if(top == stk2.peek()) stk2.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}
