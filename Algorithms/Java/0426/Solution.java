/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        } else {
            inOrder(root);
            first.left = last;
            last.right = first;
            return first;
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            if (last != null) {
                last.right = root;
                root.left = last;
            } else {
                first = root;
            }
            last = root;
            inOrder(root.right);
        }
    }
}

// class Solution {
//     public Node treeToDoublyList(Node root) {
//         if (root == null) {
//             return null;
//         } else {
//             Node headL = root.left, tailL = root.left;
//             if (root.left != null) {
//                 while (headL.left != null) {
//                     headL = headL.left;
//                 }
//                 while (tailL.right != null) {
//                     tailL = tailL.right;
//                 }
//                 treeToDoublyList(root.left);
//                 tailL.right = root;
//                 root.left = tailL;
//             }
//             Node headR = root.left, tailR = root.left;
//             if (root.right != null) {
//                 while (headR.left != null) {
//                     headR = headR.left;
//                 }
//                 while (tailR.right != null) {
//                     tailR = tailR.right;
//                 }
//                 treeToDoublyList(root.right);
//                 root.right = headR;
//                 headR.left = root;
//             }
//             if (headL != null && tailR != null) {
//                 headL.left = tailR;
//                 tailR.right = headL;
//             } else if (headL != null) {
//                 headL.left = root;
//                 root.right = headL;
//             } else if (tailR != null){
//                 root.left = tailR;
//                 tailR.right = root;
//             } else {
//                 root.right = root;
//                 root.left = root;
//             }
//             return headL != null ? headL : root;
//         }
//     }
// }
