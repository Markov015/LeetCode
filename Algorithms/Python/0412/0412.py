class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        myList = []
        for i in range(1, n + 1):
            if i % 3 == 0:
                myList.append("FizzBuzz" if i % 5 == 0 else "Fizz")
            elif i % 5 == 0:
                myList.append("Buzz")
            else:
                myList.append(str(i))
        return myList
