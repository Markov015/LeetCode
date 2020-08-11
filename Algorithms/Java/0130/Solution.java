class Solution {
    private char[][] board;
    private int m;
    private int n;

    static final int[] R = {0, -1, 0, 1};
    static final int[] C = {1, 0, -1, 0};

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }
        if (m > 1) {
            for (int j = 0; j < n; j++) {
                if (board[m - 1][j] == 'O') {
                    dfs(m - 1, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c) {
        this.board[r][c] = 'Y';
        for (int i = 0; i < 4; i++) {
            int row = r + R[i];
            int col = c + C[i];
            if (0 <= row && row < this.m && 0 <= col && col < this.n && this.board[row][col] == 'O') {
                dfs(row, col);
            }
        }
    }
}

/** 广度优先遍历 */
class Solution {
    private char[][] board;
    private int m;
    private int n;
    private Queue<int[]> queue = new LinkedList<>();

    static final int[] R = {0, -1, 0, 1};
    static final int[] C = {1, 0, -1, 0};

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.add(new int[] {0, j});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[] {i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[] {i, n - 1});
            }
        }
        if (m > 1) {
            for (int j = 0; j < n; j++) {
                if (board[m - 1][j] == 'O') {
                    queue.add(new int[] {m - 1, j});
                }
            }
        }
        bfs();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs() {
        while (!queue.isEmpty()) {
            int[] cell = queue.element();
            int r = cell[0], c = cell[1];
            this.board[r][c] = 'Y';
            for (int i = 0; i < 4; i++) {
                int row = r + R[i];
                int col = c + C[i];
                if (0 <= row && row < this.m && 0 <= col && col < this.n && this.board[row][col] == 'O') {
                    queue.add(new int[] {row, col});
                }
            }
        }
    }
}
