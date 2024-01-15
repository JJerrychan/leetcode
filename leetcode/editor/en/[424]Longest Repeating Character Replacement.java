//You are given a string s and an integer k. You can choose any character of 
//the string and change it to any other uppercase English character. You can perform 
//this operation at most k times. 
//
// Return the length of the longest substring containing the same letter you 
//can get after performing the above operations. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
// 
//
// Example 2: 
//
// 
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only uppercase English letters. 
// 0 <= k <= s.length 
// 
//
// Related Topics Hash Table String Sliding Window 👍 5475 👎 215


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0, right = 0;
        int ans = 0, longest = 0;
        while (right < s.length()) {
            map[s.charAt(right) - 'A']++;
            longest = Math.max(longest, map[s.charAt(right) - 'A']);
            right++;
            if (right - left - longest > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
        /*int longest = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            char ce = s.charAt(end);
            map.put(ce, map.getOrDefault(ce, 0) + 1);
            end++;
            longest = Math.max(longest, map.get(ce));
            if (end - start - longest > k) {
                char cs = s.charAt(start);
                map.put(cs, map.get(cs) - 1);
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
