# 线性扫描
class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        if len(A) < 3:
            return False
        n = len(A)
        i = 0
        while i < n - 1 and A[i] < A[i + 1]:
            i += 1
        return i

# 线性扫描
class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        for i in range(len(A)):
            if A[i] > A[i + 1]:
                return i

# 二分查找
class Solution:
    peakIndexInMountainArray(self, A: List[int]) -> int:
        left, right = 0, len(A) - 1
        while left < right:
            mid = left + (right - left) / 2
            if A[mid] < A[mid + 1]:
                left = mid + 1
            else:
                right = mid
       return left
