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

class Solution {
    public void reorderList(ListNode head) {
        ListNode start = head, slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now the middle element, eventually last element
        ListNode prev = null, curr = slow;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }     
        // prev is the end of the list now
        //                  null
        //                   ^
        //                   |
        // 1 -> 2 -> ... -> mid <- mid + 1 <- ... <- prev - 2 <- prev - 1
        while(start != prev && prev.next != null){
            ListNode tempS = start.next;
            ListNode tempE = prev.next;

            start.next = prev;
            prev.next = tempS;

            start = tempS;
            prev = tempE;
        }
    }
}
