// 双指针法
class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty()) {
            return 0;
        }
        int m = haystack.length(), n = needle.length();
        for (int k = 0; k <= m - n; k++) {
            int i = k, j = 0;
            while (i < m && j < n && haystack[i] == needle[j]) {
                i++; j++;
            }
            if (j == n) {
                return k;
            }
        }
        return -1;
    }
};
