class Solution {
    public int reverse(int x) {
        int rev = 0;
        if (x > 0) {
            while (x != 0) {
                int r = x % 10;
                x /= 10;
                if (rev < Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && r <= 7)) {
                    rev = rev * 10 + r;
                } else {
                    rev = 0;
                    break;
                }
            }
        } else {
            while (x != 0) {
                int r = x % 10;
                x /= 10;
                if (rev > Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && r >= -8)) {
                    rev = rev * 10 + r;
                } else {
                    rev = 0;
                    break;
                }
            }
        }
        return rev;
    }
}
