/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) List.empty[Int]
        else inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right)
    }
}

import scala.collection.mutable.{ListBuffer, Stack}

object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        val res = new ListBuffer[Int]()
        val stack = new Stack[TreeNode]()
        var curr = root
        while (curr != null || !stack.isEmpty) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            res.append(curr.value)
            curr = curr.right
        }
        res.toList
    }
}
