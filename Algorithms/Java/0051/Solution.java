class Solution {
    private int n;
    private boolean[] diagnoals; // (r, c) -> r - c + n - 1, [0, 2 * (n - 1)]
    private boolean[] antidiagnoals; // (r, c) -> r + c, [0, 2 * (n - 1)]
    private boolean[] cols; // cols[i]表示第i行是否已经放置过皇后
    private int[] queens; // queens[i]表示第i行皇后放置的位置
    private List<List<String>> ans = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            ans.add(new ArrayList<String>());
            return ans;
        }
        this.n = n;
        diagnoals = new boolean[2 * n - 1];
        antidiagnoals = new boolean[2 * n - 1];
        cols = new boolean[n];
        queens = new int[n];
        ans.clear();
        backtrack(0); // 回溯法
        return ans;
    }

    private void backtrack(int r) {
        if (r == n) {
            addSolution(); // 添加当前解到ans中
            return;
        }
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
                placeQueen(r, c);
                backtrack(r + 1);
                removeQueen(r, c);
            }
        }
    }

    private void addSolution() {
        List<String> list = new ArrayList<>();
        for (int r = 0; r < n; ++r) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; ++c) {
                sb.append(c == queens[r] ? 'Q' : '.');
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }

    private boolean canPlaceQueen(int row, int col) {
        return !cols[col] && !diagnoals[row - col + n - 1] && !antidiagnoals[row + col];
    }

    private void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = true;
        diagnoals[row - col + n - 1] = true;
        antidiagnoals[row + col] = true;
    }

    private void removeQueen(int row, int col) {
        cols[col] = false;
        diagnoals[row - col + n - 1] = false;
        antidiagnoals[row + col] = false;
    }
}
