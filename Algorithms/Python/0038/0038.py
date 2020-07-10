class Solution:
    def countAndSay(self, n: int) -> str:
        s = '1'
        for i in range(n-1):
            t = ''
            cnt = 0
            pre = s[0]
            for ch in s:
                if ch == pre:
                    cnt = cnt + 1
                else:
                    t = t + str(cnt) + pre
                    pre = ch
                    cnt = 1
            t = t + str(cnt) + pre
            s = t
        return s
