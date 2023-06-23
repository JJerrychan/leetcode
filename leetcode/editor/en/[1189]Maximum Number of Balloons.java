//Given a string text, you want to use the characters of text to form as many 
//instances of the word "balloon" as possible. 
//
// You can use each character in text at most once. Return the maximum number 
//of instances that can be formed. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: text = "nlaebolko"
//Output: 1
// 
//
// Example 2: 
//
// 
//
// 
//Input: text = "loonbalxballpoon"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: text = "leetcode"
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= text.length <= 10⁴ 
// text consists of lower case English letters only. 
// 
//
// Related Topics Hash Table String Counting 👍 1476 👎 83


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char letter : text.toCharArray()) {
            if (letter == 'b' || letter == 'a' || letter == 'l' || letter == 'n' || letter == 'o')
                map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        int res = map.getOrDefault('b', 0);
        res = Math.min(res, map.getOrDefault('a', 0));
        res = Math.min(res, map.getOrDefault('l', 0) / 2);
        res = Math.min(res, map.getOrDefault('n', 0));
        res = Math.min(res, map.getOrDefault('o', 0) / 2);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
