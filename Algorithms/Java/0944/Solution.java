class Solution {
    public int minDeletionSize(String[] A) {
        int N = A[0].length();
        int n = A.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < n; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    ++count;
                    break;
                }
            }
        }
        return count;
    }
}
