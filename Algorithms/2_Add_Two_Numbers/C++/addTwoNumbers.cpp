class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *preHead = new ListNode(-1);
        ListNode *newList = preHead;
        int carryOn = 0;
        
        while (l1 != NULL && l2 != NULL) {
            int sum = l1->val + l2->val + carryOn;
            carryOn = sum / 10;
            sum %= 10;
            newList->next = new ListNode(sum);
            newList = newList->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        ListNode *tmp = l1 == NULL ? l2: l1;
        while (tmp != NULL) {
            int sum = tmp->val + carryOn;
            carryOn = sum / 10;
            sum %= 10;
            newList->next = new ListNode(sum);
            newList = newList->next;
            tmp = tmp->next;
        }
        
        if (carryOn > 0) {
            newList->next = new ListNode(carryOn);
        }
        
        newList = preHead->next;
        delete preHead;
        return newList;
    }
};