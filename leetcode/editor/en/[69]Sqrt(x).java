/**
 * Given a non-negative integer x, return the square root of x rounded down to the
 * nearest integer. The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to
 * the nearest integer, 2 is returned.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics Math Binary Search 👍 9199 👎 4608
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 0, r = x / 2 + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int rest = x / mid;
            if (rest == mid) return mid;
            if (rest > mid) l = mid + 1;
            else r = mid;
        }
        return l - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
