class Solution {
public:
    int trailingZeroes(int n) {
        return min(getPower(n, 2), getPower(n, 5));
    }
    int getPower(int n, int p) {
        int pow = 0, m = p;
        while (m <= n) {
            pow += n / m;
            m *= p;
        }
        return pow;
    }
};

class Solution {
public:
    int trailingZeroes(int n) {
        int pow = 0, m = 5;
        while (m <= n) {
            pow += n / m;
           if (m < INT_MAX / 5 || (m == INT_MAX / 5 && (INT_MAX % m) <= 2)) {
               m *= 5;
           } else {
               break;
           }
        }
        return pow;
    }
};

class Solution {
public:
    int trailingZeroes(int n) {
        int res = 0;
        while (n) {
            n /= 5;
            res += n;
        }
        return res;
    }
};
