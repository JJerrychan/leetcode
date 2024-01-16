import java.util.Arrays;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or
 * false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 10⁴
 * s1 and s2 consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics Hash Table Two Pointers String Sliding Window 👍 10969 👎 374
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] fs1 = new int[26];
        int[] fs2 = new int[26];
        int k = s1.length();
        for(int i = 0; i < k; i++) {
            fs1[s1.charAt(i) - 'a']++;
            fs2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(fs1, fs2)) {
            return true;
        }
        for(int i = k; i < s2.length(); i++) {
            fs2[s2.charAt(i - k) - 'a']--;
            fs2[s2.charAt(i) - 'a']++;
            if(Arrays.equals(fs1, fs2)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
