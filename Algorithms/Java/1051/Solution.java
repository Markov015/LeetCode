class Solution {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) {
                ++count;
            }
        }
        return count;
    }
}
