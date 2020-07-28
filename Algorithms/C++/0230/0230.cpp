/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    int i;
    int res;
public:
    int kthSmallest(TreeNode* root, int k) {
        i = 0;
        inOrder(root, k);
        return res;
    }

    void inOrder(TreeNode* root, int k) {
        if (root->left) {
            inOrder(root->left, k);
        }
        if (++i == k) {
            res = root->val;
        }
        if (root->right) {
            inOrder(root->right, k);
        }
    }
};
