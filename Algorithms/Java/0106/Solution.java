/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int left, int right, int[] postorder, int index) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int mid = left;
        while (mid <= right && inorder[mid] != root.val) {
            ++mid;
        }
        root.left = buildTree(inorder, left, mid - 1, postorder, index - (right  - mid + 1));
        root.right = buildTree(inorder, mid + 1, right, postorder, index - 1);
        return root;
    }
}
