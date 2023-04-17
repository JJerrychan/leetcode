//Given a string text and an array of strings words, return an array of all 
//index pairs [i, j] so that the substring text[i...j] is in words. 
//
// Return the pairs [i, j] in sorted order (i.e., sort them by their first 
//coordinate, and in case of ties sort them by their second coordinate). 
//
// 
// Example 1: 
//
// 
//Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
//Output: [[3,7],[9,13],[10,17]]
// 
//
// Example 2: 
//
// 
//Input: text = "ababa", words = ["aba","ab"]
//Output: [[0,1],[0,2],[2,3],[2,4]]
//Explanation: Notice that matches can overlap, see "aba" is found in [0,2] and 
//[2,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= text.length <= 100 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 50 
// text and words[i] consist of lowercase English letters. 
// All the strings of words are unique. 
// 
//
// Related Topics Array String Trie Sorting 👍 279 👎 87


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        ArrayList<int[]> list = new ArrayList<>();
        for (String word : words) {
            int idx = text.indexOf(word);
            while (idx != -1) {
                list.add(new int[]{idx, idx + word.length() - 1});
                idx = text.indexOf(word, idx + 1);
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else return o1[0] - o2[0];
            }
        });
        return list.toArray(new int[list.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
