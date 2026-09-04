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
        //Brut Force approach
        // int sum = 0;
        // ListNode curr = head;
        // int j = 0;
        // while (curr != null) {
        //     j++;
        //     curr = curr.next;
        // }
        // int[] arr = new int[j];
        // int k = 0;
        // while (head != null) {
        //     arr[k] = head.val;
        //     k++;
        //     head = head.next;
        // }

        // for (int i = 0; i <= j / 2; i++) {
        //     int currSum = arr[i] + arr[j - 1 - i];
        //     sum = Math.max(sum, currSum);
        // }

        // return sum;

        //Optimal Approach

        if (head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode secondHalf = prev;
        ListNode firstHalf = head;
        int maxSum = 0;

        while (secondHalf != null) {
            int currSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, currSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;

    }
}