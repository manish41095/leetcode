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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null){

            //check current node duplicate or not
            if(curr.next!=null && curr.val == curr.next.val)
            {
             //move to last  duplicate node
            while(curr.next!=null && curr.val == curr.next.val){
                curr = curr.next;
            }

            //skip duplicate node
           prev.next = curr.next;
            }
            else{
                //found distinct node
                prev = prev.next;
            }
             // update curr node
             curr = curr.next;
        }
        return dummy.next;
    }
}