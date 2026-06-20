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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        if(size < k) return head;

        curr = head;
        ListNode link = head;
        ListNode prev = null;
        for(int i = 0; i < k; i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode start = prev;
        ListNode connect = link;

        while(curr != null){
            size -= k;
            if(size < k){
                link.next = curr;
                return start;
            }
            prev = null;
            connect = link;
            link = curr;
            for(int i = 0; i < k; i++){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            connect.next = prev;
            
        }

        return start;

    }
}
