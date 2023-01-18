//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in 
//O(n) time and 
//O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 10186 👎 615


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while (prev != null) {
            if (prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;

        //alternate
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode node = head;
//        while (node != null) {
//            stack.push(node);
//            node=node.next;
//        }
//        while (!stack.empty()) {
//            node = stack.pop();
//            if (head.val != node.val) return false;
//            head = head.next;
//        }
//        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
