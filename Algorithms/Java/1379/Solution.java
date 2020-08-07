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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;
        Queue<TreeNode> queueOriginal = new LinkedList<>();
        Queue<TreeNode> queueCloned = new LinkedList<>();
        queueOriginal.add(original);
        queueCloned.add(cloned);
        while (queueOriginal.size() != 0) {
            TreeNode nodeOriginal = queueOriginal.poll();
            TreeNode nodeCloned = queueCloned.poll();
            if (nodeOriginal == target) {
                res = nodeCloned;
                break;
            }
            if (nodeOriginal.left != null) {
                queueOriginal.add(nodeOriginal.left);
                queueCloned.add(nodeCloned.left);
            }
            if (nodeOriginal.right != null) {
                queueOriginal.add(nodeOriginal.right);
                queueCloned.add(nodeCloned.right);
            }
        }
        return res;
    }
}
