class Solution {
    private int differentPaths = 0; // 统计不同的路径数
    private int count = 0; // 统计已经走过的方块数
    private int nonObstacle = 0; // 统计非障碍物的方块数
    private int m;
    private int n;
    private int[] start;
    private int[] end;
    boolean[][] visited;

    private int[] R = {0, -1, 0, 1};
    private int[] C = {1, 0, -1, 0};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch(grid[i][j]) {
                    case 1: start = new int[]{i, j};
                            ++nonObstacle;
                            break;
                    case 2: end = new int[]{i, j};
                            ++nonObstacle;
                            break;
                    case 0: ++nonObstacle;
                            break;
                    case -1: visited[i][j] = true;
                            break;
                }
            }
        }
        dfs(start[0], start[1]);
        return differentPaths;
    }

    void dfs(int r, int c) {
        visited[r][c] = true;
        ++count;
        // 若当前方块为end方块
        if (r == end[0] && c == end[1]) {
            if (count == nonObstacle) ++differentPaths;
            visited[r][c] = false;
            --count;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int row = r + R[i];
            int col = c + C[i];
            if (0 <= row && row < m && 0 <= col && col < n && !visited[row][col]) {
                dfs(row, col);
            }
        }
        visited[r][c] = false;
        --count;
    }
}
