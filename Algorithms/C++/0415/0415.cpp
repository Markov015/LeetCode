class Solution {
public:
    string addStrings(string num1, string num2) {
        string res = "";
        int i = num1.size() - 1, j = num2.size() - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1[i] - '0' : 0;
            int b = j >= 0 ? num2[j] - '0' : 0;
            int t = (a + b + c) % 10;
            c = a + b + c >= 10 ? 1 : 0;
            --i; --j;
            res = '0' +
        }
    }
};
