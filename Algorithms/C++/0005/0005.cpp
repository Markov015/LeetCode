class Solution {
public:
    string longestPalindrome(string s) {
        if(s.empty()) {
            return "";
        }
        string res; int maxLen = 0;
        for(int i = 0; i < s.size(); i++) {
            int left = i, right = i;
            while(left > 0 && right < s.size()-1 && s[left-1] == s[right+1]) {
                left--; right++;
            }
            if(right-left+1 > maxLen) {
                maxLen = right - left + 1;
                res = s.substr(left, maxLen);
            }
        }
        for(int i = 0; i < s.size()-1; i++) {
            int left = i, right = i+1;
            if(s[left] != s[right]) {
                continue;
            }
            while(left > 0 && right < s.size()-1 && s[left-1] == s[right+1]) {
                left--; right++;
            }
            if(right-left+1 > maxLen) {
                maxLen = right - left + 1;
                res = s.substr(left, maxLen);
            }
        }
        return res;
    }
};
