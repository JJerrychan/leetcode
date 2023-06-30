//Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// You may assume that the given expression is always valid. All intermediate 
//results will be in the range of [-2³¹, 2³¹ - 1]. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// 
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// 
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of integers and operators ('+', '-', '*', '/') separated by some 
//number of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 2³¹ - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
//
// Related Topics Math String Stack 👍 5602 👎 720


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
