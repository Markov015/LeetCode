class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int leftSize = (m + n + 1) / 2;
        while (left < right) {
            int i = (left + right + 1) / 2;
            int j = leftSize - i;
            if (nums1[i-1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left, j = leftSize - i;
        int leftMax1 = i > 0 ? nums1[i-1] : Integer.MIN_VALUE;
        int leftMax2 = j > 0 ? nums2[j-1] : Integer.MIN_VALUE;
        int rightMin1 = i < m ? nums1[i] : Integer.MAX_VALUE;
        int rightMin2 = j < n ? nums2[j] : Integer.MAX_VALUE;
        int leftMax = Math.max(leftMax1, leftMax2);
        int rightMin = Math.min(rightMin1, rightMin2);
        return (m + n) % 2 == 0 ? (double) (leftMax + rightMin) / 2 : leftMax;
    }
}
