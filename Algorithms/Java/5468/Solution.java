class Solution {
    public int findKthPositive(int[] arr, int k) {
        boolean[] flag = new boolean[2001];
        for (int num : arr) {
            flag[num] = true;
        }
        int count = 0;
        int res = 0;
        for (int i = 1; i <= 2000; i++) {
            if (flag[i] == false) {
                if (++count == k) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }
}
