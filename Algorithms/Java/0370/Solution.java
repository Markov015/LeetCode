// brute force
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] update : updates) {
            for (int i = update[0]; i <= update[1]; i++) {
                nums[i] += update[2];
            }
        }
        return nums;
    }
}
