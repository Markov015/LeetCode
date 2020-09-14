class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private boolean exist = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               dfs(board, i, j, word, 0);
               if (exist) {
                   return true;
               }
            }
        }
        return false;
    }

    private void dfs(char[][] board, int r, int c, String word, int i) {
        if (board[r][c] == word.charAt(i)) {
            if (++i == word.length()) {
                this.exist = true;
                return;
            }
            visited[r][c] = true;
            for (int[] dir : dirs) {
                int nextRow = r + dir[0], nextCol = c + dir[1];
                if (0 <= nextRow && nextRow < board.length && 0 <= nextCol && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                    dfs(board, nextRow, nextCol, word, i);
                    if (this.exist) {
                        break;
                    }
                }
            }
            visited[r][c] = false;
        }
    }
}
