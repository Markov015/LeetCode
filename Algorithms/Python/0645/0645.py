# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        def constructMaximumBinaryTree(nums: List[int], left: int, right: int):
            if left > right:
                return None
            maxIndex = left;
            for i in range(left, right + 1):
                if nums[i] > nums[maxIndex]:
                    maxIndex = i
            root = TreeNode(nums[maxIndex])
            root.left = constructMaximumBinaryTree(nums, left, maxIndex - 1)
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, right)
            return root
        return constructMaximumBinaryTree(nums, 0, len(nums) - 1)
