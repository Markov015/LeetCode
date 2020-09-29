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
    private Map<TreeNode, Integer> mapF = new HashMap<>();
    private Map<TreeNode, Integer> mapG = new HashMap<>();

    public int minCameraCover(TreeNode root) {
        return Math.min(f(root), g(root));
    }

    private int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mapF.containsKey(root)) {
            return mapF.get(root);
        } else {
           return mapF.put(root, Math.min(f(root.left) + f(root.right),
                Math.min(f(root.left) + g(root.right),
                Math.min(g(root.left) + f(root.right),
                g(root.left) + g(root.right)))) + 1);
        }
    }

    private int g(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mapG.containsKey(root)) {
            return mapG.get(root);
        } else {
            return mapG.put(root, Math.min(f(root.left) + f(root.right),
                Math.min(f(root.left) + g(root.right),
                g(root.left) + f(root.right))));
        }
    }
}
