class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == "":
            return ""
        max_length = 0
        start, end = 0, 0
        for i in range(len(s)):
            left, right = i, i
            while left > 0 and right < len(s) - 1 and s[left - 1] == s[right + 1]:
                left, right = left - 1, right + 1
            if right - left + 1 > max_length:
                max_length = right - left + 1
                start, end = left, right
        for i in range(len(s) - 1):
            left, right = i, i + 1
            if s[left] != s[right]:
                continue
            while left > 0 and right < len(s) - 1 and s[left - 1] == s[right + 1]:
                left, right = left - 1, right + 1
            if right - left + 1 > max_length:
                max_length = right - left + 1
                start, end = left, right
        return s[start: end + 1]
