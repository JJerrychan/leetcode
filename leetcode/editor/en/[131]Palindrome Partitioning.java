//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 11213 👎 351


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        backtracking(s, ans, 0, new LinkedList<>());
        return ans;
    }

    boolean isPalind(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    void backtracking(String s, List<List<String>> ans, int idx, List<String> current) {
        if (idx == s.length()) ans.add(new LinkedList<>(current));
        for (int i = idx; i < s.length(); i++) {
            if (isPalind(s.substring(idx, i + 1))) {
                current.add(s.substring(idx, i + 1));
                backtracking(s, ans, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
