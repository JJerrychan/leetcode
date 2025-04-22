//For two strings s and t, we say "t divides s" if and only if s = t + t + t + .
//.. + t + t (i.e., t is concatenated with itself one or more times). 
//
// Given two strings str1 and str2, return the largest string x such that x 
//divides both str1 and str2. 
//
// 
// Example 1: 
//
// 
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
// 
//
// Example 2: 
//
// 
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 and str2 consist of English uppercase letters. 
// 
//
// Related Topics Math String 👍 5636 👎 1558


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean isDivided(String str, String pattern) {
        if (str.length() % pattern.length() != 0) return false;
        for (int i = 0; i < str.length(); i += pattern.length()) {
            if (!str.substring(i, i + pattern.length()).equals(pattern)) {
                return false;
            }
        }
        return true;
    }

    public String gcdOfStrings(String str1, String str2) {
        // 先找公共前缀
        int minLen = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }

        String prefix = str1.substring(0, i);

        // 从最长前缀递减尝试
        for (int len = prefix.length(); len >= 1; len--) {
            String candidate = prefix.substring(0, len);
            if (isDivided(str1, candidate) && isDivided(str2, candidate)) {
                return candidate;
            }
        }

        return "";
    }

}
//leetcode submit region end(Prohibit modification and deletion)
