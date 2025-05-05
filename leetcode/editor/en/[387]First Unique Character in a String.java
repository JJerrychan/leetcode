//Given a string s, find the first non-repeating character in it and return its 
//index. If it does not exist, return -1. 
//
// 
// Example 1: 
//
// 
// Input: s = "leetcode" 
// 
//
// Output: 0 
//
// Explanation: 
//
// The character 'l' at index 0 is the first character that does not occur at 
//any other index. 
//
// Example 2: 
//
// 
// Input: s = "loveleetcode" 
// 
//
// Output: 2 
//
// Example 3: 
//
// 
// Input: s = "aabb" 
// 
//
// Output: -1 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// Related Topics Hash Table String Queue Counting 👍 9264 👎 312


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[][] map = new int[26][2];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            queue.add(c);
            int[] e = map[c - 'a'];
            if (e[0] == 0) e[1] = i;
            e[0]++;
        }
        while (!queue.isEmpty()) {
            char a = queue.poll();
            int[] e = map[a - 'a'];
            if (e[0] == 1) return e[1];
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
