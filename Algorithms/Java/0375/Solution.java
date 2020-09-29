// brute force
class Solution {
    public int getMoneyAmount(int n) {
        return getMoneyAmount(1, n);
    }

    private int getMoneyAmount(int left, int right) {
        if (left >= right) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            res = Math.min(res, Math.max(getMoneyAmount(left, i - 1),  getMoneyAmount(i + 1, right)) + i);
        }
        return res;
    }
}

// memorized brute force
class Solution {
    private int[][] memory;

    public int getMoneyAmount(int n) {
        memory = new int[n + 1][n + 1];
        return getMoneyAmount(1, n);
    }

    private int getMoneyAmount(int left, int right) {
        if (left >= right) {
            return 0;
        } else if (memory[left][right] != 0) {
            return memory[left][right];
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            res = Math.min(res, Math.max(getMoneyAmount(left, i - 1),  getMoneyAmount(i + 1, right)) + i);
        }
        memory[left][right] = res;
        return res;
    }
}

// dynamic programming
class Solution {
    private int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int pivot = i; pivot < j; pivot++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][pivot - 1], dp[pivot + 1][j]) + pivot);
                }
            }
        }
        return dp[1][n];
    }
}

// optimized dynamic programming
class Solution {
    private int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int pivot = i + (len - 1) / 2; pivot < j; pivot++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][pivot - 1], dp[pivot + 1][j]) + pivot);
                }

            }
        }
        return dp[1][n];
    }
}
