//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 9876 👎 5456


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] charArr = s.trim().toCharArray();
        int n = charArr.length;
        reverse(charArr, 0, n - 1);

        int start = 0, end = 0;
        while (start < n) {
            // 找到一个单词的结尾
            while (end < n && charArr[end] != ' ') end++;
            reverse(charArr, start, end - 1);
            start = end + 1;
            end = start;
        }

        return cleanSpaces(charArr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private String cleanSpaces(char[] arr) {
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            // 跳过空格
            while (j < n && arr[j] == ' ') j++;
            // 拷贝单词
            while (j < n && arr[j] != ' ') arr[i++] = arr[j++];
            // 跳过单词后多余空格，只加一个
            while (j < n && arr[j] == ' ') j++;
            if (j < n) arr[i++] = ' ';
        }

        return new String(arr, 0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
