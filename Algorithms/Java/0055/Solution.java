class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] array = new boolean[n];
        array[0] = true;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == true) {
                int t = i + nums[i];
                if (t >= n - 1) {
                    array[n - 1] = true;
                    break;
                } else {
                    for (int j = right + 1; j <= t; j++) {
                        array[j] = true;
                    }
                    right = t;
                }
            }
        }
        return array[n - 1];
    }
}
