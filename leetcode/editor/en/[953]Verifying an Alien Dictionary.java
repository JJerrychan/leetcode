//In an alien language, surprisingly, they also use English lowercase letters, 
//but possibly in a different order. The order of the alphabet is some permutation 
//of lowercase letters. 
//
// Given a sequence of words written in the alien language, and the order of 
//the alphabet, return true if and only if the given words are sorted 
//lexicographically in this alien language. 
//
// 
// Example 1: 
//
// 
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is 
//sorted.
// 
//
// Example 2: 
//
// 
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
//, hence the sequence is unsorted.
// 
//
// Example 3: 
//
// 
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is 
//shorter (in size.) According to lexicographical rules "apple" > "app", because 
//'l' > '∅', where '∅' is defined as the blank character which is less than any 
//other character (More info).
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// All characters in words[i] and order are English lowercase letters. 
// 
//
// Related Topics Array Hash Table String 👍 4661 👎 1514


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean helper(String prev, String curr, int[] alpha) {
        int idx = 0;
        while (idx < prev.length() && idx < curr.length()) {
            if (alpha[prev.charAt(idx) - 'a'] < alpha[curr.charAt(idx) - 'a']) return true;
            else if (alpha[prev.charAt(idx) - 'a'] > alpha[curr.charAt(idx) - 'a']) return false;
            idx++;
        }
        return prev.length() <= curr.length() ? true : false;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++)
            alpha[order.charAt(i) - 'a'] = i;
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (!helper(prev, word, alpha)) return false;
            prev = word;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
