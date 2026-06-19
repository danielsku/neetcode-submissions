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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int min = 0;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;
            min = lists[min] == null || lists[i].val < lists[min].val ? i : min;
        }
        ListNode head = lists[min], curr = head;
        lists[min] = lists[min].next; // Recheck

        while(curr != null){
            int m = 0;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null) continue;
                m = lists[m] == null || lists[i].val < lists[m].val ? i : m;
            }
            curr.next = lists[m];
            if(lists[m] != null) lists[m] = lists[m].next;
            curr = curr.next;
        }
        return head;
    }
}
