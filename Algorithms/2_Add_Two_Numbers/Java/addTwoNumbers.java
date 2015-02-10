public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode newList = preHead;
        int carryOver = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            carryOver = sum / 10;
            sum %= 10;
            newList.next = new ListNode(sum);
            newList = newList.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode tmp = l1 == null ? l2 : l1;
        while (tmp != null) {
            int sum = tmp.val + carryOver;
            carryOver = sum / 10;
            sum %= 10;
            newList.next = new ListNode(sum);
            newList = newList.next;
            tmp = tmp.next;
        }
        
        if (carryOver > 0) {
            newList.next = new ListNode(carryOver);
        }
        
        return preHead.next;
    }
}