//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 13848 👎 642


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b;
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            }
            if (a == ')' || a == '}' || a == ']') {
                if (stack.isEmpty()) return false;
                else b = stack.pop();
                switch (a) {
                    case ')':
                        result = b == '(' ? true : false;
                        break;
                    case '}':
                        result = b == '{' ? true : false;
                        break;
                    case ']':
                        result = b == '[' ? true : false;
                        break;
                }
            }
            if (result == false) return result;
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
