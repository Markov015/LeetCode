class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        count_target, count_arr = [0] * 1001, [0] * 1001
        for num in target:
            count_target[num] += 1
        for num in arr:
            count_arr[num] += 1
        ans = True
        for i in range(1, 1001):
            if count_target[i] != count_arr[i]:
                ans = false
                break
        return ans
