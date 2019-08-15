/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        
        if (fast == null) {
            return head.next;
        }
        
        ListNode curr = head;
        while (fast.next != null) {
            fast = fast.next;
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        
        return head;
    }
    
}