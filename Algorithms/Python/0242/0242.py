class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        d = {}
        for ch in s:
            if ch in d:
                d[ch] += 1
            else:
                d[ch] = 1
        for ch in t:
            if ch in d:
                d[ch] -= 1
                if d[ch] < 0:
                    return False
            else:
                return False
        return True
