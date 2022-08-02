//Given two strings s and t, return true if they are equal when both are typed 
//into empty text editors. '#' means a backspace character. 
//
// Note that after backspacing an empty text, the text will continue empty. 
//
// 
// Example 1: 
//
// 
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
// 
//
// Example 2: 
//
// 
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
// 
//
// Example 3: 
//
// 
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 200 
// s and t only contain lowercase letters and '#' characters. 
// 
//
// 
// Follow up: Can you solve it in O(n) time and O(1) space? 
//
// Related Topics Two Pointers String Stack Simulation 👍 5267 👎 226


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else stack1.push(c);
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else stack2.push(c);
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty() || stack2.isEmpty() || stack1.pop() != stack2.pop()) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
