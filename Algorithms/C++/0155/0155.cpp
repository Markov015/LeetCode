class MinStack {
private:
    vector<int> data;
    vector<int> delta;
    int minIndex;
    int minElement;
public:
    MinStack() {
        minIndex = -1;
        minElement = INT_MAX;
    }

    void push(int x) {
        data.push_back(x);
        if (x < minElement) {
            int newMinIndex = data.size() - 1;
            delta.push_back(newMinIndex - minIndex);
            minIndex = newMinIndex;
            minElement = x;
        }
    }

    void pop() {
        int x = data.back();

        if (x == data[minIndex]) {
            minIndex -= delta.back();
            minElement = data[minIndex];
            delta.pop_back();
        }

        data.pop_back();
    }

    int top() {
        return data.back();
    }

    int getMin() {
        return data[minIndex];
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
