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
    private TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    // private void inOrder(TreeNode root, int delta) {
    //     if (root != null) {
    //         if (root.right != null) {
    //             inOrder(root.right, delta);
    //             root.val += root.right.val;
    //         } else {
    //             root.val += delta;
    //         }
    //         if (root.left != null) {
    //             inOrder(root.left, root.val);
    //         }
    //     }
    // }

    // private int inOrder(TreeNode root) {
    //     if (root != null) {
    //         root.val += inOrder(root.right);
    //         if (root.left != null) {
    //             root.left.val += root.val;
    //             return inOrder(root.left);
    //         } else {
    //             return root.val;
    //         }
    //     } else {
    //         return 0;
    //     }
    // }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.right);
            root.val += pre == null ? 0 :pre.val;
            pre = root;
            inOrder(root.left);
        }
    }
}
