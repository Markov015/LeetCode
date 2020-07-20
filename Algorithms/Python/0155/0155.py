class MinStack:


    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = [math.inf]

    def push(self, x: int) -> None:
        self.minStack.append(min(minStack[-1], x))
        self.stack.append(x)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return stack[-1]

    def getMin(self) -> int:
        return MinStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
