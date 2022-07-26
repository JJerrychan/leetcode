//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 👍 13847 👎 522


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backtracking(n, 0, 0, ans, "");
        return ans;
    }

    void backtracking(int n, int left, int right, List<String> ans, String str) {
        if (left == right && left == n) {
            ans.add(str);
            return;
        }
        if (left < n) backtracking(n, left + 1, right, ans, str + "(");
        if (right < left) backtracking(n, left, right + 1, ans, str + ")");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
