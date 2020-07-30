class Solution {
public:
    int integerBreak(int n) {
        vector<int> A(n+1); A[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                A[i] = max(A[i], A[j] * (i - j));
                A[i] = max(A[i], j * (i - j));
            }
        }
        return A[n];
    }
};
