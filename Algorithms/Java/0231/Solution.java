class Solution {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & ~(n & (-n))) == 0;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }
}
