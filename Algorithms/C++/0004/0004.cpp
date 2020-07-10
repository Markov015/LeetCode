class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.size(), n = nums2.size();
        int leftSize = (m + n + 1) / 2;
        int left = 0, right = m;
        while (left < right) {
            int i = (left + right + 1) / 2, j = leftSize - i;
            if (nums1[i-1] <= nums2[j]) {
                left = i;
            } else {
                right = i - 1;
            }
        }
        int i = left, j = leftSize - i;
        int leftMax1 = i > 0 ? nums1[i-1] : INT_MIN;
        int leftMax2 = j > 0 ? nums2[j-1] : INT_MIN;
        int rightMin1 = i < m ? nums1[i] : INT_MAX;
        int rightMin2 = j < n ? nums2[j] : INT_MAX;
        if ((m + n) % 2) {
            return max(leftMax1, leftMax2);
        } else {
            return (double) (max(leftMax1, leftMax2) + min(rightMin1, rightMin2)) / 2;
        }
    }
};
