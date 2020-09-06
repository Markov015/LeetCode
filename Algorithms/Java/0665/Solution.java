class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i;
                ++count;
            }
        }
        if (count == 0) {
            return true;
        } else if (count == 1) {
            if (k == 0 || k == n - 2) {
                return true;
            } else {
                return nums[k - 1] <= nums[k + 1] || nums[k] <= nums[k + 2];
            }
        } else {
            return false;
        }
    }
}
