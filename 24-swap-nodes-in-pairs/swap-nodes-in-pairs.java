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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Create a dummy node to act as the predecessor of the head    
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 'curr' tracks the node right before the pair we want to swap
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode swap1 = curr.next;
            ListNode swap2 = curr.next.next;

            swap1.next = swap2.next; // 1. Connect swap1 node to the rest of the list
            swap2.next = swap1; // 2. Point swap2 node back to the first node

            curr.next = swap2; // 3. Connect the curr part of the list to the second node
            curr = swap1; // Move 'curr' forward by two nodes 
        }
        return dummy.next;

    }
}