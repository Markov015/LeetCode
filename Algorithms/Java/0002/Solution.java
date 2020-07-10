/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode((a + b + carry) % 10);
            tail = tail.next;
            carry = a + b + carry >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
