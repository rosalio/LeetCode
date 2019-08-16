/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode currNode = head;
        for (int i = 0; i < k - 1; i++) {
            currNode = currNode.next;
            if (currNode == null) {
                return head;
            }
        }
        
        ListNode headOfNext = currNode.next;
        currNode.next = null;
        ListNode newHead = reverseList(head);
        
        currNode = newHead;
        for (int i = 0; i < k - 1; i++) {
            currNode = currNode.next;
        }
    
        currNode.next = reverseKGroup(headOfNext, k);
        return newHead;
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