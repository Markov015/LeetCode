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
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, path);
        return paths;
    }

    private void dfs(TreeNode root, int target, List<Integer> path) {
        if (root != null) {
            target -= root.val;
            path.add(root.val);
            if (root.left == null && root.right == null && target == 0) {
                paths.add(List.copyOf(path));
            } else {
                if (root.left != null) {
                    dfs(root.left, target, path);
                }
                if (root.right != null) {
                    dfs(root.right, target, path);
                }
            }
            path.remove(path.size() - 1);
        }
    }
}
