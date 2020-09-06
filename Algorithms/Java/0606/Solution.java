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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(String.valueOf(root.val));
            if (root.left != null || root.right != null) {
                sb.append('(');
                preOrder(root.left, sb);
                sb.append(')');
                if (root.right != null) {
                    sb.append('(');
                    preOrder(root.right, sb);
                    sb.append(')');
                }
            }
        }
    }
}
