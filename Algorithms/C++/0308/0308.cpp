class NumMatrix {
private:
    vector<vector<int>> matrix;
    vector<vector<int>> sum;
    int m, n;
public:
    NumMatrix(vector<vector<int>>& _matrix) {
        if (_matrix.empty()) {
            return;
        }
        this->matrix = _matrix;
        m = _matrix.size() + 1;
        n = _matrix[0].size() + 1;
        sum.resize(m);
        for (auto& vec : sum) {
            vec.assign(n , 0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + _matrix[i - 1][j - 1];
            }
        }
    }

    void update(int row, int col, int val) {
        for (int i = row + 1; i < m; i++) {
            for (int j = col + 1; j < n; j++) {
                sum[i][j] += val - matrix[row][col];
            }
        }
        matrix[row][col] = val;
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * obj->update(row,col,val);
 * int param_2 = obj->sumRegion(row1,col1,row2,col2);
 */
