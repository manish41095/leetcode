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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
         // 1. Find the middle of the linked list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }  

        ListNode firstHalfHead = head;
        
        // 2. Reverse the second half of the linked list
        ListNode secondHalfHead = reverse(slow);

        ListNode copySecondHalf = secondHalfHead;

        boolean isPalindrome = true;
        // 3. Compare the first half and the reversed second half
        while(secondHalfHead != null){
            if(firstHalfHead.val != secondHalfHead.val){
               isPalindrome = false;
               break;
            }
             firstHalfHead = firstHalfHead.next;
             secondHalfHead = secondHalfHead.next;  
        }

        // 4. Restore the original list structure (good interview practice)
        reverse(copySecondHalf);

        return isPalindrome;
        
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;

        ListNode curr = head;
        while(curr != null){
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }
        return prev;
    }
}