/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def invertTree(root: TreeNode): TreeNode = {
        if (root == null) {
            null
        } else {
            val left = invertTree(root.left)
            val right = invertTree(root.right)
            root.left = right
            root.right = left
            root
        }
    }
}
