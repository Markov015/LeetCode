class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 1) {
            return s.equals("0") ? 0 : 1;
        } else if (n == 2) {
            int value = Integer.valueOf(s);
            if (s.charAt(1) == '0') {
                return value == 10 || value == 20 ? 1 : 0;
            } else {
                int res = numDecodings(s.substring(0, 1));
                if (10 <= value && value <= 26) {
                    res += 1;
                }
                return res;
            }
        } else {
            int[] dp = new int[n];
            dp[0] = numDecodings(s.substring(0, 1));
            dp[1] = numDecodings(s.substring(0, 2));
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] * numDecodings(s.substring(i, i + 1));
                int value = Integer.valueOf(s.substring(i - 1, i + 1));
                if (10 <= value && value <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n - 1];
        }
    }
}
