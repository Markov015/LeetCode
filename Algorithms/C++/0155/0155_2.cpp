class MinStack {
private:
    stack<int> data;
    stack<int> minStack;
public:
    MinStack() {
        minStack.push(INT_MAX);
    }

    void push(int x) {
        minStack.push(min(minStack.top(), x));
        data.push(x);
    }

    void pop() {
        data.pop();
        minStack.pop();
    }

    int top() {
        return data.top();
    }

    int getMin() {
        return minStack.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
