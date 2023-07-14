//Given a string s and an integer k, return the length of the longest substring 
//of s that contains at most k distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3. 
//
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: The substring is "aa" with length 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
//
// Related Topics Hash Table String Sliding Window 👍 2687 👎 77


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0;
        int longest = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (left <= right && right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            right++;
            if (map.size() > k) {
                if (map.get(s.charAt(left)) == 1) map.remove(s.charAt(left));
                else map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
