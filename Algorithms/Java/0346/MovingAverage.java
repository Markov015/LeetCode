class MovingAverage {
    private Queue<Integer> queue = new LinkedList<>();
    private int windowSize;
    private int sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int windowSize) {
        this.windowSize = windowSize;
    }

    public double next(int val) {
        if (queue.size() < windowSize) {
            sum += val;
            queue.add(val);
        } else {
            sum -= queue.remove();
            queue.add(val);
            sum += val;
        }
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
