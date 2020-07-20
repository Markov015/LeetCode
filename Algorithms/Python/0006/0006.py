class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        res = ""
        n, offset = len(s), 2 * (numRows - 1)
        res = res + s[0 : n : offset]
        for row in range(1, numRows - 1):
            for i in range(row, n, offset):
                res = res + s[i]
                idx = i + 2 * (numRows - 1 - row)
                if idx < n:
                    res = res + s[idx]
        res = res + s[numRows - 1 : n : offset]
        return res
