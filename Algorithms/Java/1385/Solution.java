class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int disatanceValue = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean vaild = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    vaild = false;
                    break;
                }
            }
            if (vaild) {
                ++disatanceValue;
            }
        }
        return disatanceValue;
    }
}
