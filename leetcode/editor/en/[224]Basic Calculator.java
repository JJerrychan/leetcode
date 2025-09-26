//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
//
// Related Topics Math String Stack Recursion 👍 6772 👎 545


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, number = 0, result = 0;
        for (char a : s.toCharArray()) {
            if (Character.isDigit(a)) {
                number = 10 * number + Character.getNumericValue(a);
            } else if (a == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (a == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (a == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (a == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
