//Given a string s, sort it in decreasing order based on the frequency of the 
//characters. The frequency of a character is the number of times it appears in the 
//string. 
//
// Return the sorted string. If there are multiple answers, return any of them. 
//
//
// 
// Example 1: 
//
// 
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid 
//answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and 
//"aaaccc" are valid answers.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
//
// Example 3: 
//
// 
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s consists of uppercase and lowercase English letters and digits. 
// 
//
// Related Topics Hash Table String Sorting Heap (Priority Queue) Bucket Sort 
//Counting 👍 8670 👎 308


import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequent = new HashMap<>();
        for (char a : s.toCharArray()) {
            frequent.put(a, frequent.getOrDefault(a, 0) + 1);
        }
        LinkedList<Character> list = new LinkedList<>(frequent.keySet());
        list.sort((a, b) -> frequent.get(b) - frequent.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int i = 0; i < frequent.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
