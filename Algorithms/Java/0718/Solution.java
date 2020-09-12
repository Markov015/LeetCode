class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int k = i; k > 0; k--) {
                    dp[i][j] = Math.max(dp[i][j], helper(A, B, k - 1, j - 1));
                }
            }
        }
        return dp[m][n];
    }

    private int helper(int[] A, int[] B, int i, int j) {
        int res = 0;
        while (i >= 0 && j >= 0 && A[i] == B[j]) {
            ++res;
            --i;
            --j;
        }
        return res;
    }
}
