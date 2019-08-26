/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        process(head);
    }
    
    private ListNode process(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode newHead = head.next;
        ListNode curr = head;
        ListNode tail = curr.next;
        while (tail.next != null) {
            curr = curr.next;
            tail = tail.next;
        }
        
        head.next = tail;
        curr.next = null;
        tail.next = process(newHead);
        return head;
    }
}