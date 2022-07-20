//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same 
//character, but a character may map to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
// Related Topics Hash Table String 👍 4154 👎 756


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i), a = t.charAt(i);
            if (map.containsKey(c) || map.containsValue(a)) {
                if (map.get(c) == null || map.get(c) != a) return false;
            } else {
                map.put(c, a);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
