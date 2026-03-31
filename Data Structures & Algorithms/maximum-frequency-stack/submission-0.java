class FreqStack {
    Stack<Stack<Integer>> freqStack;
    Map<Integer, Integer> freq;
    public FreqStack() {
        freqStack = new Stack<>();
        freq = new HashMap<>();
    }
    
    public void push(int val) {
        int valFreq = freq.getOrDefault(val, 0);
        freq.put(val, ++valFreq);

        if(freqStack.size() < valFreq) freqStack.push(new Stack<Integer>());
        freqStack.get(valFreq - 1).push(val);
    }
    
    public int pop() {
        int val = freqStack.peek().pop();
        freq.put(val, freq.get(val) - 1);
        if(freqStack.peek().size() == 0) freqStack.pop();
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */