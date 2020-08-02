// Arrays.sort()
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

// 计数
class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
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
}

// 交换
class Solution {
    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1, cur = 0;
        while (cur <= q) {
            if (nums[cur] == 0) {
                int tmp = nums[p];
                nums[p++] = nums[cur];
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                int tmp = nums[q];
                nums[q--] = nums[cur];
                nums[cur] = tmp;
            } else {
                ++cur;
            }
        }
    }
}
