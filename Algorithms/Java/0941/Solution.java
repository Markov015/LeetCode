class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left + 1 < n && A[left] < A[left + 1]) {
            ++left;
        }
        while (right >= 1 && A[right] < A[right - 1]) {
            --right;
        }
        return left == right && 0 < left && left < n - 1;
    }
}

class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        while (i < n - 1 && A[i] < A[i + 1]) {
            ++i;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        while (i < n - 1 && A[i] > A[i + 1]) {
            ++i;
        }
        return i == n - 1;
    }
}
