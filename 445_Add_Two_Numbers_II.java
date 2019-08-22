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
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        int carry = 0;
        
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(carry % 10);
            currNode.next = newNode;
            currNode = currNode.next;
            carry /= 10;
        }
        return reverseList(dummyHead.next);
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode first = head;
        ListNode second = first.next;
        first.next = null;
        while (second != null) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        return first;
    }
}