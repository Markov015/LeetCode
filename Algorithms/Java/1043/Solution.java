class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int tempMax = 0;
        for (int i = 0; i < k; i++) {
            tempMax = Math.max(tempMax, arr[i]);
            dp[i] = tempMax * (i + 1);
        }   
        for (int i = k; i < n; i++) {
            tempMax = 0;
            for (int j = 0; j < k; j++) {
                tempMax = Math.max(tempMax, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j - 1] + tempMax * (j + 1));
            }
        }
        return dp[n - 1];
    }
}
