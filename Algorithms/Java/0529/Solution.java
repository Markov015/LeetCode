class Solution {
    private final int[] R = {0, -1, -1, -1, 0, 1, 1, 1};
    private final int[] C = {1, 1, 0, -1, -1, -1, 0, 1};
    private char[][] board;
    private int m;
    private int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        int r = click[0], c = click[1];
        char ch = board[r][c];
        switch (ch) {
            case 'M': // 如果一个地雷被挖出
                board[r][c] = 'X';
                break;
            case 'E': // 如果一个没有相邻地雷的空方快被挖出
                int count = countMine(r, c);
                if (count == 0) {
                    board[r][c] = 'B';
                    updateNeighbors(r, c);
                } else {
                    board[r][c] = (char)('0' + count);
                }
                break;
            default:
                break;
        }
        return board;
    }

    /**
    * 递归更新周围未挖出的方块
    */
    private void updateNeighbors(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int row = r + R[i];
            int col = c + C[i];
            if (0 <= row && row < m && 0 <= col && col < n && board[row][col] == 'E') {
                updateBoard(board, new int[] {row, col});
            }
        }
    }

    /**
    *    返回相应位置周围的地雷数量
    */
    private int countMine(int r, int c) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row = r + R[i];
            int col = c + C[i];
            if (0 <= row && row < m && 0 <= col && col < n && (board[row][col] == 'M' || board[row][col] == 'X')) {
                ++count;
            }
        }
        return count;
    }
}
