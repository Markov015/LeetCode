class Solution {
public:
    bool isPalindrome(string s) {
        string t;
        for (char ch : s) {
            if (isalnum(ch)) {
                t += tolower(ch);
            }
        }
        s = t;
        reverse(s.begin(), s.end());
        return s == t;
    }
};
