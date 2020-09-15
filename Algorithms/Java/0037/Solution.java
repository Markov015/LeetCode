class Solution {
    // row[r][i]表示第r行是否出现过i+1
    private boolean[][] row = new boolean[9][9];
    // col[c][i]表示第c列是否出现过i+1
    private boolean[][] col = new boolean[9][9];
    // block[i][j][k]表示第i行第j列的block是否出现过k+1
    private boolean[][][] block = new boolean[3][3][9];
    // spaces保存未填充的空格
    private List<int[]> spaces = new ArrayList<>();
    // 数独
    private char[][] board;
    // 标记是否已经找到解
    private boolean vaild = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = board[i][j] - '1';
                    row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(0);
    }

    private void dfs(int pos) {
        if (pos == spaces.size()) {
            this.vaild = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !vaild; digit++) {
            if (!row[i][digit] && !col[j][digit] && !block[i / 3][j / 3][digit]) {
                board[i][j] = (char)(digit + '1');
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                dfs(pos + 1);
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
