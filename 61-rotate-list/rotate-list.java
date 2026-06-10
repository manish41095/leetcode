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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int count = 1;
        ListNode tail = head;
        ListNode curr = head;

        while(tail.next!=null){
            count++;
            tail = tail.next;
        }

        int counter = k % count;
       
        if(counter == 0)
         return head;
        //Make circular LL
        tail.next = head;

        for(int i = 0; i < count-counter-1 ; i++){
            curr = curr.next;
        }
        //Break the ll and update the head
        head = curr.next;
        curr.next = null;


        return head;
        
    }
}