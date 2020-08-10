class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, temp1 = 1, temp2 = 1;
        for (int num : nums) {
            temp1 *= num;
            max = Math.max(max, temp1);
            if (temp1 <= 0) temp1 = 1;
            temp2 *= num;
            max = Math.max(max, temp2);
            if (temp2 == 0) temp2 = 1;
        }
        temp1 = temp2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp1 *= nums[i];
            max = Math.max(max, temp1);
            if (temp1 <= 0) temp1 = 1;
            temp2 *= nums[i];
            max = Math.max(max, temp2);
            if (temp2 == 0) temp2 = 1;
        }
        return max;
    }
}


class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxT = maxF, minT = minF;
            maxF = Math.max(maxT * nums[i], Math.max(nums[i], minT * nums[i]));
            minF = Math.min(maxT * nums[i], Math.min(nums[i], minT * nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
