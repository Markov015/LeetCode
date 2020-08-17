class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            int tempSame = diff;
            int tempDiff = (same + diff) * (k - 1);
            same = tempSame;
            diff = tempDiff;
        }
        return same + diff;
    }
}
class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][2];
        dp[1][1] = k;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n][0] + dp[n][1];
    }
}

class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        // 考虑柱子数量为2的情形
        int f = k; // f用来表示最后两个柱子颜色相同的方案数
        int g = k * (k - 1); // g用来表示最后两个柱子颜色不同的方案数
        // 考虑柱子数量为i情形和i-1情形的关系
        for (int i = 3; i <= n; i++) {
            int tempF = g;
            int tempG = (f + g) * (k - 1);
            f = tempF;
            g = tempG;
        }
        return f + g;
    }
}
