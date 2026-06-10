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
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode high = new ListNode(0);

        ListNode smallHead = small;
        ListNode highHead = high;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val < x){
                //small list
                smallHead.next = curr;
                smallHead = smallHead.next;
            }
            else{
                //high list
                highHead.next = curr;
                highHead = highHead.next;
            }
            curr = curr.next;
        }

        
        highHead.next = null;
        smallHead.next = high.next;
        return small.next;
        
    }
}