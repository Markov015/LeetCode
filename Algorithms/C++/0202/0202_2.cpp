// 快慢指针法
class Solution {
public:
    bool isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int m = n;
        while (m != 1 && m != n) {
            n = getNext(n);
            m = getNext(getNext(m));
        }
        return m == 1;
    }

    int getNext(int n) {
        int sum = 0;
        while (n) {
            int r = n % 10;
            sum += r * r;
            n /= 10;
        }
        return sum;
    }
};
