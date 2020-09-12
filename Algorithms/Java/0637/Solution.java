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
     private List<Double> res = new ArrayList<>();

     public List<Double> averageOfLevels(TreeNode root) {
            levelOrder(root);
            return res;
     }

     private void levelOrder(TreeNode root) {
         if (root == null) {
             return;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             int size = queue.size();
             double sum = 0.0;
             for (int i = 0; i < size; i++) {
                 TreeNode curr = queue.remove();
                 sum += curr.val;
                 if (curr.left != null) {
                     queue.add(curr.left);
                 }
                 if (curr.right != null) {
                     queue.add(curr.right);
                 }
             }
             res.add(sum / size);
         }
     }
 }

class Solution {
    private List<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root != null) {
             levelOrder(root);
        }
        return res;
    }

    private void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(sum / size);
        }
    }
}
