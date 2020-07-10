# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummyHead = ListNode();
        tail = dummyHead;
        carry = 0
        while l1 or l2:
            a = 0
            b = 0
            if l1:
                a = l1.val
                l1 = l1.next
            if l2:
                b = l2.val
                l2 = l2.next
            tail.next = ListNode((a + b + carry) % 10);
            tail = tail.next
            carry = 1 if a + b + carry >= 10 else 0
        tail.next = None if carry == 0 else ListNode(1)
        return dummyHead.next
