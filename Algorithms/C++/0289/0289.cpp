class Solution {
private:
    vector<vector<int>> res;
    int R[3] = {-1, 0, 1};
    int C[3] = {-1, 0, 1};
public:
    void gameOfLife(vector<vector<int>>& board) {
        res = board;
        for (int r = 0; r < res.size(); r++) {
            for (int c = 0; c < res[r].size(); c++) {
                int k = getLiveNeighbors(r, c, board);
                if (res[r][c] == 1) {
                    if (k < 2 || k > 3) {
                        res[r][c] = 0;
                    }
                } else if (k == 3) {
                    res[r][c] = 1;
                }
            }
        }
        board = res;
    }
    int getLiveNeighbors(int r, int c, vector<vector<int>>& board) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = r + R[i];
                int col = c + C[j];
                if (row >= 0 && row < board.size() && col >= 0 && col < board[0].size()) {
                    cnt += board[row][col];
                }
            }
        }
        cnt -= board[r][c];
        return cnt;
    }
};
