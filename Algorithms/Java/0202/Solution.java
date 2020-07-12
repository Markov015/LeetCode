class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int m = getNext(n);
        while (m != 1 && m != n) {
            n = getNext(n);
            m = getNext(getNext(m));
        }
        return m == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int r = n % 10;
            sum +=  r * r;
            n /= 10;
        }
        return sum;
    }
}
