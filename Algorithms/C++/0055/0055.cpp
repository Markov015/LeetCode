class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<bool> v(n, false);
        v[0] = true;
        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            if (v[i]) {
                int t = i + nums[i];
                if (t >= n - 1) {
                    return true;
                } else if (t > right) {
                    for (int j = right + 1; j <= t; j++) {
                        v[j] = true;
                    }
                    right = t;
                }
            }
        }
        return v[n - 1];
    }
};
