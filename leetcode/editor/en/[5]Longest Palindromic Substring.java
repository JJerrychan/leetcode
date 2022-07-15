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
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > longest.length()) longest = s.substring(l + 1, r);

            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > longest.length()) longest = s.substring(l + 1, r);
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
