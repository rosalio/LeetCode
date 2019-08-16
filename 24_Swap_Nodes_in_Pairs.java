/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        
        second.next = first;
        first.next = swapPairs(third);
        return second;
    }
}