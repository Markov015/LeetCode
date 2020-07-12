class Solution {
public:
    const long M = 1000000007;
    int numSub(string s) {
        map<int, int> m; // len -> cnt
        int i = 0, j = 0;
        while (i < s.length()) {
            while (i < s.length() && s[i] != '1') {
                i++;
            }
            j = i;
            while (j < s.length() && s[j] == '1') {
                j++;
            }
            m[j-i]++;
            i = j;
        }


        long res = 0;
        for (auto it : m) {
            long len = it.first, cnt = it.second;
            res = (res + cnt * len * (len + 1) / 2) % M;
        }
        return (int)res;
    }
};
