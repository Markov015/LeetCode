// 使用库函数sort
class Solution {
public:
    void sortColors(vector<int>& nums) {
        sort(nums.begin(), nums.end());
    }
};

// 记录0，1，2的个数
class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> cnt(3, 0);
        for (int num : nums) {
            ++cnt[num];
        }
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
};

// 荷兰三色旗问题
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        // p指示0的最右边界，q指示2的最左边界
        int p = 0, q = n - 1;
        while (p < n && nums[p] == 0) {
            ++p;
        }
        while (q >= 0 && nums[q] == 2) {
            --q;
        }
        int cur = p;
        while (cur <= q) {
            if (nums[cur] == 0) {
                swap(nums[cur++], nums[p++]);
            } else if (nums[cur] == 2) {
                swap(nums[cur], nums[q--]);
            } else {
                ++cur;
            }
        }
    }
};

// 荷兰三色旗问题
class Solution {
public:
    void sortColors(vector<int>& nums) {
        // p指示0的最右边界，q指示2的最左边界
        int p = 0, q = nums.size() - 1, cur = 0;
        while (cur <= q) {
            if (nums[cur] == 0) {
                swap(nums[cur++], nums[p++]);
            } else if (nums[cur] == 2) {
                swap(nums[cur], nums[q--]);
            } else {
                ++cur;
            }
        }
    }
};
