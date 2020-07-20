/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *dummyHead = new ListNode(0);
        dummyHead->next = head;
        ListNode *p = dummyHead, *q = dummyHead;
        for (int i = 0; i < n; i++) {
            q = q->next;
        }
        while (q->next) {
            p = p->next;
            q = q->next;
        }
        p->next = p->next->next;
        return dummyHead->next;
    }
};
