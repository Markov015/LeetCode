class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else {
             return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }
    }

    private int rob(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        int n = right - left + 1;
        int[] S = new int[n];
        int[] T = new int[n];
        S[0] = nums[left];
        for (int i = 1; i < n; i++) {
            S[i] = T[i - 1] + nums[left + i];
            T[i] = Math.max(S[i - 1], T[i - 1]);
        }
        return Math.max(S[n - 1], T[n - 1]);
    }
}
