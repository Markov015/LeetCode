class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int beginIndex = i;
            int endIndex = i + 1;
            while (beginIndex >= 0 && endIndex <= n) {
                if (isPalindromic(s.substring(beginIndex, endIndex))) {
                    ++count;
                }
                --beginIndex;
                ++endIndex;
            }
            beginIndex = i;
            endIndex = i + 2;
            while (beginIndex >= 0 && endIndex <= n) {
                if (isPalindromic(s.substring(beginIndex, endIndex))) {
                    ++count;
                }
                --beginIndex;
                ++endIndex;
            }
        }
        return count;
    }

    private boolean isPalindromic(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
