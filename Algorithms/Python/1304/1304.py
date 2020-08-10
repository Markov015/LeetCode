class Solution:
    def sumZero(self, n: int) -> List[int]:
        ans = [0] * n
        for i in range(n >> 1):
            ans[2 * i], ans[2 * i + 1] =  i + 1, - (i + 1)
        return ans
