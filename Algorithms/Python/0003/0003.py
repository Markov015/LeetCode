class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == "":
            return 0
        map, res, i = {}, 0, -1
        for j in range(len(s)):
            if s[j] in map and map[s[j]] > 0:
                while True:
                    i = i + 1
                    if s[i] == s[j]:
                        break
                    else:
                        map[s[i]] = 0
            else:
                map[s[j]] = 1
            res = max(res, j - i)
        return res
