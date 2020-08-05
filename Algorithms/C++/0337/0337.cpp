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
private:
    map<TreeNode*, int> f, g;
public:
    int rob(TreeNode* root) {
        postOrder(root);
        return max(f[root], g[root]);
    }

    void postOrder(TreeNode* root) {
        if (root != nullptr) {
            postOrder(root->left);
            postOrder(root->right);
            f[root] = g[root->left] + g[root->right] + root->val;
            g[root] = max(f[root->left], g[root->left]) + max(f[root->right], g[root->right]);
        }
    }
};
