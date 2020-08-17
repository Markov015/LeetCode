class Solution {
    private int[][] grid;
    private int m;
    private int n;
    private final int[] R = {0, -1, 0, 1};
    private final int[] C = {1, 0, -1, 0};
    private int res = 0;
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        int i = 0, j = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    break;
                }
            }
            if (j < n && grid[i][j] == 1) {
                break;
            }
        }
        return i < m ? bfs(i, j) : 0;
    }

    private int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] pair = queue.remove();
            r = pair[0];
            c = pair[1];
            for (int i = 0; i < 4; i++) {
                int row = r + R[i];
                int col = c + C[i];
                if (0 <= row && row < m && 0 <= col && col < n) {
                    if (grid[row][col] == 1) {
                        if (!visited[row][col]) {
                            queue.add(new int[] {row, col});
                            visited[row][col] = true;
                        }
                    } else {
                        ++res; // 海水
                    }
                } else {
                    ++res; // 坐标不合法
                }
            }
        }
        return res;
    }
}
