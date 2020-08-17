class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int maxHeightSum = 0;
        int[] maxHorizotalHeight = new int[n];
        int[] maxVerticalHeight = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHorizotalHeight[i] = Math.max(maxHorizotalHeight[i], grid[i][j]);
                maxVerticalHeight[j] = Math.max(maxVerticalHeight[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeightSum += Math.max(Math.min(maxHorizotalHeight[i],
                    maxVerticalHeight[j]) - grid[i][j], 0);
            }
        }
        return maxHeightSum;
    }
}
