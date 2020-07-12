class Solution:
    def isHappy(self, n: int) -> bool:
        def getNext(n: int) -> int:
            sum = 0
            while n:
                n, r =  divmod(n, 10)
                sum += r ** 2
            return sum
        m = getNext(n)
        while m != 1 and m != n:
            n = getNext(n)
            m = getNext(getNext(m))
        return m == 1
