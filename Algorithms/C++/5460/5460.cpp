class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        map<int, int> m;
        for (auto x : nums) {
            m[x]++;
        }
        int res = 0;
        for (auto it : m) {
            int n = it.second;
            res += n * (n-1) /2;
        }
        return res;
    }
};
