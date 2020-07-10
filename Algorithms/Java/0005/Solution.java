class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLength = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left > 0 && right < s.length() -1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--; right++;
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left; end = right;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i, right = i + 1;
            if (s.charAt(left) != s.charAt(right)) {
                continue;
            }
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--; right++;
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left; end = right;
            }
        }
        return s.substring(start, end + 1); // String substring(int beginIndex, int endIndex)
    }
}
