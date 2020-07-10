# Binary Search
class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        while left < right:
            mid = math.floor((left + right + 1) / 2)
            if mid * mid <= x:
                left = mid
            else:
                right = mid - 1
        return left
