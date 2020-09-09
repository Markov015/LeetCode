class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        private int[][] count = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    count[i][j] = matrix[i][j];
                } else {
                    count[i][j] = matrix[i][j] == 0 ? 0 : Math.min(count[i - 1][j - 1], Math.min(count[i][j - 1], count[i - 1][j])) + 1;
                }
                res += count[i][j];
            }
        }
        return res;
    }
}

class Solution {
    private int[][] dp;

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int count = 0;
                for (int delta = 0; delta <= Math.min(i, j); delta++) {
                    boolean isAllOne = true;
                    for (int r = i - delta; r <= i; r++) {
                        if (matrix[r][j - delta] == 0) {
                            isAllOne = false;
                            break;
                        }
                    }
                    if (isAllOne) {
                        for (int c = j - delta + 1; c <= j; c++) {
                            if (matrix[i - delta][c] == 0) {
                                isAllOne = false;
                                break;
                            }
                        }
                    }
                    if (isAllOne) {
                        ++count;
                    } else {
                        break;
                    }
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + count;
            }
        }
        return dp[m - 1][n - 1];
    }
}
