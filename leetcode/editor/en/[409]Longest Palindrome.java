//Given a string s which consists of lowercase or uppercase letters, return the 
//length of the longest palindrome that can be built with those letters. 
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome 
//here. 
//
// 
// Example 1: 
//
// 
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose 
//length is 7.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 
//1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
//
// Related Topics Hash Table String Greedy 👍 3154 👎 177


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) % 2 == 0) {
                    ans += 2;
                }
            } else {
                map.put(c, 1);
            }
        }
        return s.length() == ans ? ans : ans + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
