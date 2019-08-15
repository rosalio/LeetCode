/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}