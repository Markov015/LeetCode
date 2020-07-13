 class Solution:
    def firstUniqChar(self, s: str) -> int:
        cnt = [0 for i in range(26)]
        for ch in s:
            cnt[ord(ch) - ord('a')] += 1
        for i in range(len(s)):
            if cnt[ord(s[i]) - ord('a')] == 1:
                return i
        return -1
