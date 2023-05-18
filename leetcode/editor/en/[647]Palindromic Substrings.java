//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 9013 👎 190


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//            ans++;
//        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        ans++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
