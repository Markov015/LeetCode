class Solution {
    public int integerBreak(int n) {
        int[] A = new int[n + 1];
        A[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                A[i] = Math.max(A[i], A[j] * (i - j));
                A[i] = Math.max(A[i], j * (i - j));
            }
        }
        return A[n];
    }
}
