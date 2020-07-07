class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for idx, val in enumerate(nums):
            complement = target - val
            if complement in map:
                return map[complement], idx
            map[val] = idx
