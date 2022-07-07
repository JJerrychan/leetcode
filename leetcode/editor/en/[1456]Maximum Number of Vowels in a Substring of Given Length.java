//Given a string s and an integer k, return the maximum number of vowel letters 
//in any substring of s with length k. 
//
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'. 
//
// 
// Example 1: 
//
// 
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
// 
//
// Example 2: 
//
// 
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
// 
//
// Example 3: 
//
// 
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 1 <= k <= s.length 
// 
// Related Topics String Sliding Window 👍 774 👎 40


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int max = 0, count = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) count++;
        }
        max = count;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i - k))) count--;
            if (set.contains(s.charAt(i))) count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
