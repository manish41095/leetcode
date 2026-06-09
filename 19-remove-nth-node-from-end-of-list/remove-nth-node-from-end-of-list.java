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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        //ListNode slow = dummy, fast = dummy;
        while(n > 0){
           fast = fast.next;
           n --;
        }

       while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
       }

       if(slow != null && slow.next != null){
           slow.next = slow.next.next;
       }
      
        
        // for(int i = 0 ; i < n ;i++){
        //     p2 = p2.next;
        // }
        // while(p2.next!=null){
        //     p1=p1.next;
        //     p2=p2.next;
        // }

        // p1.next = p1.next.next;

      return dummy.next;
    }
}