class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            ++left;
            --right;
        }
        if (left < right) {
            return isPanlindrome(s.substring(left + 1, right + 1)) ||
                isPanlindrome(s.substring(left, right));
        } else {
            return true;
        }
    }

    private boolean isPanlindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
