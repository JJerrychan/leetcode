//You are given an array of strings words. Each element of words consists of 
//two lowercase English letters. 
//
// Create the longest possible palindrome by selecting some elements from words 
//and concatenating them in any order. Each element can be selected at most once. 
//
//
// Return the length of the longest palindrome that you can create. If it is 
//impossible to create any palindrome, return 0. 
//
// A palindrome is a string that reads the same forward and backward. 
//
// 
// Example 1: 
//
// 
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of 
//length 6.
//Note that "clgglc" is another longest palindrome that can be created.
// 
//
// Example 2: 
//
// 
//Input: words = ["ab","ty","yt","lc","cl","ab"]
//Output: 8
//Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt",
// of length 8.
//Note that "lcyttycl" is another longest palindrome that can be created.
// 
//
// Example 3: 
//
// 
//Input: words = ["cc","ll","xx"]
//Output: 2
//Explanation: One longest palindrome is "cc", of length 2.
//Note that "ll" is another longest palindrome that can be created, and so is 
//"xx".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Greedy Counting 👍 587 👎 15


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String[] words) {
        int longest = 0, count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder(s);
            String re = sb.reverse().toString();
            if (map.containsKey(re) && map.get(re) > 0) {
                if (s.charAt(0) == s.charAt(1)) count--;
                map.put(re, map.get(re) - 1);
                longest += 4;
            } else {
                if (s.charAt(0) == s.charAt(1)) count++;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
//            if (!map.containsKey(s)) {
//                if (map.containsKey(re) && map.get(re) > 0) {
//                    if (s.charAt(0) == s.charAt(1)) count--;
//                    map.put(re, map.get(re) - 1);
//                    longest += 4;
//                } else {
//                    if (s.charAt(0) == s.charAt(1)) count++;
//                    map.put(s, 1);
//                }
//            } else {
//                if (s.charAt(0) == s.charAt(1)) count++;
//                map.put(s, map.get(s) + 1);
//            }
        }
        if (count > 0) longest += 2;
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
