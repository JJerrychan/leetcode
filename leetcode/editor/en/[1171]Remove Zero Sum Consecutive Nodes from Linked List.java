//Given the head of a linked list, we repeatedly delete consecutive sequences 
//of nodes that sum to 0 until there are no such sequences. 
//
// After doing so, return the head of the final linked list. You may return any 
//such answer. 
//
// 
// (Note that in the examples below, all sequences are serializations of 
//ListNode objects.) 
//
// Example 1: 
//
// 
//Input: head = [1,2,-3,3,1]
//Output: [3,1]
//Note: The answer [1,2,1] would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,-3,4]
//Output: [1,2,4]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,-3,-2]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The given linked list will contain between 1 and 1000 nodes. 
// Each node in the linked list has -1000 <= node.val <= 1000. 
// 
//
// Related Topics Hash Table Linked List 👍 3456 👎 224


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode node = head; node != null; node = node.next) {
            sum += node.val;
            map.put(sum, node);
        }
        sum = 0;
        head = dummy;
        while (head != null) {
            sum += head.val;
            if (map.containsKey(sum)) head.next = map.get(sum).next;
            head = head.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
