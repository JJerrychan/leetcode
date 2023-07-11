//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 19718 👎 1139


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*Brute Froce*/
    /*boolean isPalindromic(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String longest = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    String sub = s.substring(i, j + 1);
                    if (isPalindromic(sub)) {
                        longest = sub.length() > longest.length() ? sub : longest;
                        break;
                    }
                }
            }
        }
        return longest;
    }*/

    /*Dynamic Programming*/
    /*public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                l = i;
                r = i + 1;
            }
        }
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }*/

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(expand(i, i, s), expand(i, i + 1, s));
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    int expand(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
