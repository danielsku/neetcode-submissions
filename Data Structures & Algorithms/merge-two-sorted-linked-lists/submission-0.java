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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode curr1 = list1, curr2 = list2;
        ListNode head = null;
        if(curr1.val > curr2.val){
            head = curr2;
            curr2 = curr2.next;
        }else {
            head = curr1;
            curr1 = curr1.next;
        }
        ListNode current = head;

        while(curr1 != null && curr2 != null){
            if(curr1.val > curr2.val){
                current.next = curr2;
                curr2 = curr2.next;
            } else {
                current.next = curr1;
                curr1 = curr1.next;
            }
            current = current.next;
        }

        while(curr1 != null){
            current.next = curr1;
            curr1 = curr1.next;
            current = current.next;
        }

        while(curr2 != null){
            current.next = curr2;
            curr2 = curr2.next;
            current = current.next;
        }

        return head;
    }
}