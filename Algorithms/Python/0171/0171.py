class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        for ch in s:
            res = res * 26 + (ord(ch) - ord('A') + 1)
        return res

class Solution:
    def titleToNumber(self, s: str) -> int:
        return sum(26 ** i * (ord(ch) - ord('A') + 1) for i, ch in enumuerate(s[::-1]))
