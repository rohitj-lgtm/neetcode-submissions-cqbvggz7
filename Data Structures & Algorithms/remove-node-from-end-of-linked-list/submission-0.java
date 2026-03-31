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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0, head);
        int size = 0;
        ListNode temp = dummy;
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }

        size -= n;
        temp = dummy;
        while(size != 0) {
            size--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
