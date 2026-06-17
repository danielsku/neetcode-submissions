/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
// Solve tomorrow

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int sum = l1.val + l2.val;

        head.val = sum % 10;
        int overhead = sum / 10;
        // Account for the overhead too

        ListNode curr = head;

        l1 = l1.next; 
        l2 = l2.next;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + overhead;
            overhead = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = temp;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int value = l1.val + overhead;
            overhead = value/10;
            ListNode temp = new ListNode(value % 10);
            curr.next = temp;
            curr = temp;
            l1 = l1.next;
        }

        while(l2 != null){
            int value = l2.val + overhead;
            overhead = value/10;
            ListNode temp = new ListNode(value % 10);
            curr.next = temp;
            curr = temp;
            l2 = l2.next;
        }

        if(overhead != 0){
            ListNode temp = new ListNode(overhead);
            curr.next = temp;
        }

        return head;
    }
}
