//Write a function that reverses a string. The input string is given as an 
//array of characters s. 
//
// You must do this by modifying the input array in-place with O(1) extra 
//memory. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
// Related Topics Two Pointers String Recursion 👍 5402 👎 964


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    void reverMethod(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverMethod(s, ++left, --right);
    }

    public void reverseString(char[] s) {
        reverMethod(s, 0, s.length - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
