/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        ListNode* lastOddNode = head;
        while (lastOddNode->next && lastOddNode->next->next) {
            lastOddNode = lastOddNode->next->next;
        }
        ListNode* tail = lastOddNode;
        ListNode* lastEvenNode = lastOddNode->next;
        ListNode* cur = head;
        while (cur != lastOddNode) {
            tail = tail->next = cur->next;
            cur = cur->next = cur->next->next;
        }
        tail->next = lastEvenNode;
        return head;
    }
};
