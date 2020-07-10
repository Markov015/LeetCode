class Solution:
    def myAtoi(self, str: str) -> int:
        if str == "":
            return 0

        start, end = 0, len(str)
        while start < end and str[start] == ' ':
            start = start + 1
        if start == end:
            return 0

        negative = False
        if str[start] == '+':
           start = start + 1
        else:
           negative = True
           start = start + 1
        if start == end:
           return 0

        end = start + 1
        while end < len(str) and str[end].isdigit():
           end = end + 1
        if start < end:
           str = str[start: end]
        else:
           return 0

        # val = int(str)
       #
       #
       # val = 0
       # for i in range(len(str)):
       #     t = str[i] - '0'
