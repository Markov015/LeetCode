class Solution:
    res = []
    map = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "xyz"}
    def letterCombinations(self, digits: str) -> List[str]:
        def DFS(i: int, t: str):
            if i == len(digits):
                res.append(t)
            else:
                s = digits[i]
                for j in range(len(s)):
                    DFS(i + 1, t + s[j])

        if (len(digits) != 0):
            DFS(0, "")
        return res
