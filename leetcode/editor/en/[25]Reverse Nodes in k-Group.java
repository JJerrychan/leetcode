//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
//
// Related Topics Linked List Recursion 👍 10231 👎 560


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy, end = head;
        int count = 0;
        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end.next);
                end = start.next;
            } else end = end.next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start, curr = start.next, first = curr;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;


        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
