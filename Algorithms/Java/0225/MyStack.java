class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    private int tail; // 队列的tail，也即模拟的栈的top

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        this.tail = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() > 1) {
            temp.add(queue.remove());
        }
        int ret = queue.remove();
        while (!temp.isEmpty()) {
            push(temp.remove());
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        return this.tail;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
