class MyQueue {
    private Stack<Integer> stack = new Stack<>();
    private int bottom; // 栈的底部，也即队列的front

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        if (stack.size() == 1) {
            this.bottom = x;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (stack.size() > 1) {
            temp.push(stack.pop());
        }
        int ret = stack.pop();
        while (!temp.empty()) {
            push(temp.pop());
        }
        return ret;
    }

    /** Get the front element. */
    public int peek() {
        return this.bottom;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
