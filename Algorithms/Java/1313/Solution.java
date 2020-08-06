class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int totalLength = 0;
        for (int i = 0; i < n; i += 2) {
            totalLength += nums[i];
        }
        int[] list = new int[totalLength];
        int fromIndex = 0, toIndex;
        for (int i = 0; i < n; i += 2) {
            toIndex = fromIndex + nums[i];
            Arrays.fill(list, fromIndex, toIndex, nums[i + 1]);
            fromIndex = toIndex;
        }
        return list;
    }
}
