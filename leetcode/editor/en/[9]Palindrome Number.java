/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 1
 * 21-. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * <p>
 * Related Topics Math 👍 13056 👎 2766
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int y = x;
        int i = 1;
        while (y / 10 != 0) {
            y = y / 10;
            i *= 10;
        }

        y = x;
        while (i > 0) {
            if (x < 10) return true;
            if (x / i != y % 10) return false;
            x = x % i;
            y = y / 10;
            i /= 10;
        }


        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
