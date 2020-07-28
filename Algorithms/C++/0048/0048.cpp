class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int row, col, nextRow, nextCol, tmp;
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    row = i; col = j; tmp = matrix[i][j];
                    for (int k = 0; k < 4; k++) {
                        nextRow = col;
                        nextCol = n - 1 - row;
                        swap(tmp, matrix[nextRow][nextCol]);
                        row = nextRow;
                        col = nextCol;
                    }
                }
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j <= n / 2; j++) {
                    row = i; col = j; tmp = matrix[i][j];
                    for (int k = 0; k < 4; k++) {
                        nextRow = col;
                        nextCol = n - 1 - row;
                        swap(tmp, matrix[nextRow][nextCol]);
                        row = nextRow;
                        col = nextCol;
                    }
                }
            }
        }
    }
};

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int r = i, c = j, t = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    swap(t, matrix[c][n - 1 - r]);
                    int x = r; r = c; c = n - 1 - x;
                }
            }
        }
    }
};
