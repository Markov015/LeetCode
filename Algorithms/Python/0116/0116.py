"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        p, q = root.left, root.right
        while p != None and q != None:
            p.next = q
            p, q = p.right, q.left
        self.connect(root.left)
        self.connect(root.right)
        return root
