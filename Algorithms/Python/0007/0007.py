class Solution:
    def reverse(self, x: int) -> int:
        rev = 0
        INT_MAX = 2 ** 31 -1
        INT_MIN = -INT_MAX - 1
        negative = False
        if x != INT_MIN:
            if x < 0:
                x, negative = -x, True
            while x != 0:
                r, x = x % 10, x // 10
                if rev < INT_MAX // 10 or (rev == INT_MAX // 10 and r <= 7):
                    rev = rev * 10 + r
                else:
                    rev = 0
                    break
        return rev if not negative else -rev
