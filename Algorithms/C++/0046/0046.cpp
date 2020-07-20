class Solution {
public:
    vector<vector<int>> res;
    vector<int> vec;
    vector<bool> vis;
    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        vis.resize(n, false);
        DFS(nums, 0, n);
        return res;
    }
    void DFS(vector<int>& nums, int depth, int n) {
        if (depth == n) {
            res.push_back(vec);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                vec.push_back(nums[i]);
                DFS(nums, depth + 1, n);
                vec.pop_back();
                vis[i] = false;
            }
        }
    }
};
