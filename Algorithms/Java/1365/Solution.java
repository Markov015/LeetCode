class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    ++res[i];
                }
            }
        }
        return res;
    }
}

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int[] prefixSum = new int[102];
        int n = nums.length;
        for (int num : nums) {
            ++cnt[num];
        }
        for (int i = 1; i < 102; i++) {
            prefixSum[i] = prefixSum[i - 1] + cnt[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefixSum[nums[i]];
        }
        return res;
    }
}
