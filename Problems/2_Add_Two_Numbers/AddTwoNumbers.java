/**********************************************************************************************************************

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

**********************************************************************************************************************/

class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("2. Add Two Numbers");

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        printListNode(a1);
        printListNode(b1);

        ListNode result = addTwoNumbers(a1, b1);
        printListNode(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        int carry = 0;

        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode(l1.val + l2.val + carry);
            curr.next = newNode;
            curr = newNode;
            if (curr.val >= 10) {
                curr.val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = (l1 == null) ? l2 : l1;
        while (l != null) {
            ListNode newNode = new ListNode(l.val + carry);
            curr.next = newNode;
            curr = newNode;
            if (curr.val >= 10) {
                curr.val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l = l.next;
        }

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            curr.next = newNode;
            newNode.next = null;
        }

        return pre.next;
    }

    private static void printListNode(ListNode node) {
        ListNode currNode = node;
        while (currNode != null) {
            System.out.print(currNode.val);
            currNode = currNode.next;
        }
        System.out.print("\n");
    }

    /**
     * Definition for singly-linked list.
    **/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
