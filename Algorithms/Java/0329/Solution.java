// 记忆化深度优先搜索
class Solution {
    private int m, n;
    private int[][] matrix;
    private int[][] memory;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memory = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        memory[i][j] = 1;
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            if (0 <= r && r < m && 0 <= c && c < n && matrix[i][j] < matrix[r][c]) {
                memory[i][j] = Math.max(memory[i][j], dfs(r, c) + 1);
            }
        }
        return memory[i][j];
    }
}
