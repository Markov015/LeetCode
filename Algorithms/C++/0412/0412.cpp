class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> v(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                v[i-1] = i % 5 ? "Fizz" : "FizzBuzz";
            } else if (i % 5 == 0) {
                v[i-1] = "Buzz";
            } else {
                stringstream ss;
                ss << i;
                ss >> v[i-1];
            }
        }
        return v;
    }
};
