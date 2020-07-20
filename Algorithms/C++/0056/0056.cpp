class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if (intervals.empty()) {
            return res;
        }
        sort(intervals.begin(), intervals.end());
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] <= right) {
                right = max(right, intervals[i][1]);
            } else {
                res.push_back(vector<int> {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.push_back(vector<int> {left, right});
        return res;
    }
};
