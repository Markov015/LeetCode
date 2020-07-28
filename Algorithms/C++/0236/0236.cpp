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
    unordered_map<TreeNode*, TreeNode*> parent;
    unordered_map<TreeNode*, bool> vis;
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        DFS(root);
        while (p != nullptr) {
            vis[p] = true;
            p = parent[p];
        }
        while (q != nullptr) {
           if (vis[q]) {
               return q;
           } else {
               q = parent[q];
           }
        }
        return nullptr;
    }

    void DFS(TreeNode* root) {
        if (root != nullptr) {
            if (root->left != nullptr) {
                parent[root->left] = root;
                DFS(root->left);
            }
            if (root->right != nullptr) {
                parent[root->right] = root;
                DFS(root->right);
            }
        }
    }
};
