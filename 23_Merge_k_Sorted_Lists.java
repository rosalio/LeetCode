/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        return merge(lists, 0, len - 1);
    }
    
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        
        if (l1 != null) {
            currNode.next = l1;
        } else if (l2 != null) {
            currNode.next = l2;
        }
        return dummyHead.next;
    }
}