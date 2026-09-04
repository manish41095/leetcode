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
    public int pairSum(ListNode head) {
        int sum = 0;

        //int[] arr = new int[];

        ListNode curr = head;
        int j = 0;
        while (curr != null) {
            j++;
            curr = curr.next;
        }
        int[] arr = new int[j];
        int k = 0;
        while (head != null) {
            arr[k] = head.val;
            k++;
            head = head.next;
        }

        for (int i = 0; i <= j / 2; i++) {
            int currSum = arr[i] + arr[j - 1 - i];
            sum = Math.max(sum, currSum);
        }

        return sum;

    }
}