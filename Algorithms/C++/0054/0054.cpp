class Solution {
public:
    vector<int> R {0, 1, 0, -1};
    vector<int> C {1, 0, -1, 0};
    vector<vector<bool>> vis;
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        if (matrix.empty()) {
            return res;
        }
        int m = matrix.size(), n = matrix[0].size();
        vis.resize(m);
        for(auto& v : vis) {
            v.assign(n, false);
        }
        int r = 0, c = 0, next = 0, cnt = 0;
        while (cnt < m * n) {
            if (!vis[r][c]) {
                res.push_back(matrix[r][c]);
                vis[r][c] = true;
                ++cnt;
            }
            int rNext = r + R[next];
            int cNext = c + C[next];
            if(rNext >= 0 && cNext >= 0 && rNext < m && cNext < n && !vis[rNext][cNext]) {
                r = rNext;
                c = cNext;
            }  else {
                next = (next + 1) % 4;
            }
        }
        return res;
    }
};
