class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        string res;
        int offset = 2 * (numRows - 1);
        for (int j = 0; j < s.size(); j += offset) {
            res += s[j];
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i; j < s.size(); j += offset) {
                res += s[j];
                int idx = j +  2 * (numRows - 1 - i);
                if (idx < s.size()) {
                    res += s[idx];
                }
            }
        }
        for (int j = numRows - 1; j < s.size(); j += offset) {
            res += s[j];
        }
        return res;
    }
};
