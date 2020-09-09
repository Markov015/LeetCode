class Solution {
    int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        dp = new int[len + 1][m + 1][n + 1];
        for(int index = 1; index <= len; index++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (char ch : strs[index - 1].toCharArray()) {
                if (ch == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (zeroCount <= i && oneCount <= j) {
                        dp[index][i][j] = Math.max(dp[index - 1][i - zeroCount][j - oneCount] + 1, dp[index - 1][i][j]);
                    } else {
                        dp[index][i][j] = dp[index - 1][i][j];
                    }
                }
            }

        }
        return dp[len][m][n];
    }
}

// 超出时间限制
// class Solution {
//     public int findMaxForm(String[] strs, int m, int n) {
//         return dp(strs, 0, m, n);
//     }
//
//     private int dp(String[] strs, int index, int m, int n) {
//         if(index == strs.length) {
//             return 0;
//         }
//         int zeroCount = 0;
//         int oneCount = 0;
//         for (char ch : strs[index].toCharArray()) {
//             if (ch == '0') {
//                 zeroCount++;
//             } else {
//                 oneCount++;
//             }
//         }
//         if (zeroCount <= m && oneCount <= n) {
//             return Math.max(dp(strs, index + 1, m - zeroCount, n - oneCount) + 1, dp(strs, index + 1, m, n));
//         } else {
//             return dp(strs, index + 1, m, m);
//         }
//     }
// }
