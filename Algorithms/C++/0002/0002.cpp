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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        ListNode *head = new ListNode(0), *cur = head;
        while(l1 || l2) {
            int x = l1 ? l1->val : 0, y = l2 ? l2->val : 0;
            cur->next = new ListNode((x + y + carry) % 10); cur = cur->next;
            carry = (x + y + carry > 9) ? 1 : 0;
            l1 = l1 ? l1->next : NULL; l2 = l2 ? l2->next : NULL;
        }
        if(carry)
            cur->next = new ListNode(carry);
        return head->next;
    }
};
