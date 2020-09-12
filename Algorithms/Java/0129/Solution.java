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
     public int sumNumbers(TreeNode root) {
         return preOrder(root, 0);
     }

     private int preOrder(TreeNode root, int temp) {
         if (root == null) {
             return 0;
         }
         temp = temp * 10 + root.val;
         if (root.left == null && root.right == null) {
             return temp;
         } else {
             return preOrder(root.left, temp) + preOrder(root.right, temp);
         }
     }
 }

class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        preOrder(root, 0);
        return sum;
    }

    private void preOrder(TreeNode root, int temp) {
        if (root == null) {
            return;
        }
        temp = 10 * temp + root.val;
        if (root.left != null || root.right != null) {
            preOrder(root.left, temp);
            preOrder(root.right, temp);
        } else {
            sum += temp;
        }
    }
}
