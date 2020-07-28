class Solution {
private:
    vector<vector<int>> res;
    vector<int> vec;
    vector<bool> vis;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        vis.assign(n, false);
        res.push_back(vector<int> ());
        for (int i = 0; i < n; i++) {
            DFS(i, nums);
        }
        return res;
    }

    void DFS(int i, vector<int>& nums) {
        vec.push_back(nums[i]);
        vis[i] = true;
        res.push_back(vec);
        for (int j = i; j < nums.size(); j++) {
            if (!vis[j]) {
                DFS(j, nums);
            }
        }
        vis[i] = false;
        vec.pop_back();
    }
};
