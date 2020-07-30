# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        stack = []
        pre, cur = None, root
        while cur != None or len(stack) != 0:
            while cur != None:
                stack.append(cur)
                cur = cur.left
            cur = stack[-1]
            stack.pop()
            if pre == p:
                return cur
            pre = cur
            cur = cur.right
        return None
