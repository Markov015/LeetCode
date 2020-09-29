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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (!stack.isEmpty() && curr == stack.peek()) {
                curr = curr.right;
            } else {
                list.add(curr.val);
                curr = null;
            }
        }
        return list;
    }
}
