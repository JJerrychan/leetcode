//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 8197 👎 266


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s.length() < p.length()) return list;
        int[] map = new int[26];
        for (char a : p.toCharArray()) map[a - 'a']++;

        int start = 0, end = 0;
        int toBeMatched = p.length();

        while (end < s.length()) {
            char curr = s.charAt(end);
            if (map[curr - 'a'] > 0)  toBeMatched--;
            map[curr - 'a']--;
            end++;
            if (end - start > p.length()) {
                char curs = s.charAt(start);
                if (map[curs - 'a'] >= 0) toBeMatched++;
                map[curs - 'a']++;
                start++;
            }
            if (toBeMatched == 0) list.add(start);
        }
        return list;
    }

    /*public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        for (char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int toBeMatched = map.size();
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) toBeMatched--;
            }
            right++;
            if (right - left > p.length()) {
                char curl = s.charAt(left);
                if (map.containsKey(curl)) {
                    if (map.get(curl) == 0) toBeMatched++;
                    map.put(curl, map.get(curl) + 1);
                }
                left++;
            }
            if (toBeMatched == 0) list.add(left);
        }
        return list;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
