/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if (root == nullptr) {
            return nullptr;
        }
        Node* p = root->left;
        Node* q = root->right;
        while (p != nullptr && q!= nullptr) {
            p->next = q;
            p = p->right;
            q = q->left;
        }
        connect(root->left);
        connect(root->right);
        return root;
    }
};
