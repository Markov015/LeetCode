class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        flag = [False] * n
        flag[0] = True
        right = 0
        for i in range(n - 1):
            if i > right:
                break
            t = i + nums[i]
            if t >= n - 1:
                flag[-1] = True
                break
            elif t > right:
                for j in range(right + 1, t + 1):
                    flag[j] = True
                right = t
        return flag[-1]
