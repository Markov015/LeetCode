class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        m, n = len(nums1), len(nums2)
        INT_MAX = sys.maxsize
        INT_MIN = -sys.maxsize - 1
        leftSize = math.ceil((m + n) / 2)
        left, right = 0, m
        while left < right:
            i = math.ceil((left + right) / 2)
            j = leftSize - i
            if (nums1[i-1] < nums2[j]):
                left = i
            else:
                right = i - 1
        i = math.ceil((left + right) / 2)
        j = leftSize - i
        leftMax1 = INT_MIN if i == 0 else nums1[i-1]
        leftMax2 = INT_MIN if j == 0 else nums2[j-1]
        rightMin1 = INT_MAX if i == m else nums1[i]
        rightMin2 = INT_MAX if j == n else nums2[j]
        leftMax = max(leftMax1, leftMax2)
        rightMin = min(rightMin1, rightMin2)
        if (m + n) % 2 == 0:
            return (leftMax + rightMin) / 2
        else:
            return leftMax
