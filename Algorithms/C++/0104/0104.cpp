/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        queue<TreeNode*> q; q.push(root);
        int depth = 0;
        while (!q.empty()) {
            ++depth;
            int n = q.size(), cnt = 0;
            while (n--) {
                TreeNode* node = q.front(); q.pop();
                if (node->left != nullptr) {
                    q.push(node->left);
                    ++cnt;
                }
                if (node->right != nullptr) {
                    q.push(node->right);
                    ++cnt;
                }
            }
        }
        return depth;
    }
};
