//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics Math Dynamic Programming Recursion Memoization 👍 4428 👎 276


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        //1.Recursion
        /*if (n < 2) {
            return n == 0 ? 0 : 1;
        }
        return fib(n - 1) + fib(n - 2);*/
        //2.DP
        if (n < 1) return 0;
        int[] map = new int[n+1];
        map[0] = 0;
        map[1] = 1;
        for (int i = 2; i <= n; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
