class Solution:
    def hammingWeight(self, n: int) -> int:
        b = 1
        res = 1 if n & b else 0
        for i in range(31):
            b = b << 1
            if n & b:
                res += 1
        return res
