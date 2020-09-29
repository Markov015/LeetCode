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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null) {
            return res;
        }
        s1.push(root);
        boolean reverse = false;
        while (!s1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                list.add(curr.val);
                if (!reverse) {
                    if (curr.left != null) {
                        s2.add(curr.left);
                    }
                    if (curr.right != null) {
                        s2.add(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        s2.add(curr.right);
                    }
                    if (curr.left != null) {
                        s2.add(curr.left);
                    }
                }
            }
            res.add(list);
            Stack<TreeNode> temp = s1;
            s1 = s2;
            s2 = temp;
            reverse = !reverse;
        }
        return res;
    }
}
