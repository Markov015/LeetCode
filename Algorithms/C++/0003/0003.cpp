class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s == "") {
            return 0;
        }
        map<char, int> m;
        int res = 0, i = -1;
        for (int j = 0; j < s.size(); j++) {
            if (m[s[j]] > 0) {
                while(s[++i] != s[j]) {
                    m[s[i]]--;
                }
            } else {
                m[s[j]]++;
            }
            res = max(res, j - i);
        }
        return res;
    }
};
