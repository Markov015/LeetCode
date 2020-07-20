class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def DFS(nLeft: int, nRight: int, t: str):
            if nLeft == n and nRight == n:
                res.append(t)
                return
            if nLeft < n:
                DFS(nLeft + 1, nRight, t + "(")
            if nRight < nLeft:
                DFS(nLeft, nRight + 1, t + ")")
        DFS(0, 0, "")
        return res

# class Solution:
#     def generateParenthesis(self, n: int) -> List[str]:
#         if n == 0:
#             return [""]
#         res = []
#         for i in range(n):
#             for
