class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        // k为奇数时，A[k] > A[k - 1]
        // k为偶数时，A[k] < A[k - 1]
        int[] f = new int[n];
        f[0] = 1;
        // k为奇数时，A[k] < A[k - 1]
        // k为偶数时，A[k] > A[k - 1]
        int[] g = new int[n];
        g[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                if (A[i] < A[i - 1]) {
                    f[i] = f[i - 1] + 1;
                    g[i] = 1;
                } else if(A[i] > A[i - 1]) {
                    f[i] = 1;
                    g[i] = g[i - 1] + 1;
                } else {
                    f[i] = 1;
                    g[i] = 1;
                }
            } else {
                if (A[i] < A[i - 1]) {
                    f[i] = 1;
                    g[i] = g[i - 1] + 1;
                } else if (A[i] > A[i - 1]) {
                    f[i] = f[i - 1] + 1;
                    g[i] = 1;
                } else {
                    f[i] = 1;
                    g[i] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(f[i], g[i]));
        }
        return res;
    }
}
