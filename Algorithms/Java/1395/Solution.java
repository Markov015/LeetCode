class Solution {
    private int[] great; // great[i]表示在i之后且比rating[i]大的rating的数量
    private int[] less; // less[i]表示在i之后且比rating[i]小的rating的数量

    public int numTeams(int[] rating) {
        int n = rating.length;
        great = new int[n];
        less = new int[n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) {
                    ++great[i];
                    count += great[j];
                } else if(rating[j] < rating[i]) {
                    ++less[i];
                    count += less[j];
                }
            }
        }
        return count;
    }
}
