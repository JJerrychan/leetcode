//Given a string s, reverse the order of characters in each word within a 
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
//
// 
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// 
//
// Example 2: 
//
// 
//Input: s = "Mr Ding"
//Output: "rM gniD"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
//
// Related Topics Two Pointers String 👍 6122 👎 253


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int idx = 0;

        while (idx < n) {
            int l = idx, r = idx;
            while (r + 1 < n && arr[r + 1] != ' ') r++;
            idx = r + 2;
            while (l < r) {
                char tem = arr[l];
                arr[l] = arr[r];
                arr[r] = tem;
                l++;
                r--;
            }
        }
        return new String(arr);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
