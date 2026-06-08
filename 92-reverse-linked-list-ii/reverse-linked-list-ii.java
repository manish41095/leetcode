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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftPre = dummy;
        ListNode curr = head;
        for(int i = 0; i < left -1; i++){
            leftPre = leftPre.next; ;
            curr = curr.next;
        }
        ListNode subHead = curr;

        ListNode prevNode = null;
        for(int i = 0; i < right - left + 1; i++){
            ListNode newNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = newNode;
        }
        leftPre.next = prevNode;
        subHead.next = curr;

        return dummy.next;
    }
}