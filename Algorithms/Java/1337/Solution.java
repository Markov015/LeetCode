class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[][] rows = new int[n][2];
        for (int i = 0; i < n; i++) {
            rows[i][0] = i; // row index
            for (int num : mat[i]) {
                if (num == 1) {
                    ++rows[i][1]; // num of soldiers
                }
            }
        }
        Arrays.sort(rows, 0, n, (r1, r2) -> r1[1] != r2[1] ? r1[1] - r2[1] : r1[0] - r2[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = rows[i][0];
        }
        return res;
    }
}
