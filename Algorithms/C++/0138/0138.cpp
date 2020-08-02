/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* dummyHead = new Node(0);
        Node* tail = dummyHead;
        map<Node*, Node*> mp;
        Node *p = head;
        while (p != nullptr) {
            tail->next = new Node(p->val);
            mp[p] = tail->next;
            tail = tail->next;
            p = p->next;
        }
        p = head;
        Node* q = dummyHead->next;
        while (p != nullptr) {
            if (p->random != nullptr) {
                q->random = mp[p->random];
            }
            p = p->next;
            q = q->next;
        }
        return dummyHead->next;
    }
};
