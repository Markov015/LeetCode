class Solution {
public:
    bool isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        set<int> s;
        while (n != 1) {
            int sum = 0;
            while (n) {
                int r = n % 10;
                sum += r * r;
                n /= 10;
            }
            n = sum;
            if (s.find(n) != s.end()) {
                return false;
            } else {
                s.insert(n);
            }
        }
        return true;
    }
};
