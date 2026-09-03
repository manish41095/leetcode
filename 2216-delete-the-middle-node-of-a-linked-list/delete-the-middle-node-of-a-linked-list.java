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
    public ListNode deleteMiddle(ListNode head) {

        int count = 0;
        ListNode curr = head;

        if(head.next==null)
        return null;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int mid = count / 2;

        ListNode temp = head;

        for (int i = 0; i < mid - 1; i++) {
            head = head.next;
        }

        if (head.next == null)
            head.next = null;

        else {
            head.next = head.next.next;
        }

        return temp;

    }
}