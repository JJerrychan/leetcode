//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// 
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
//
// Related Topics Math String Bit Manipulation Simulation 👍 6508 👎 683


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        if (aa.length < bb.length) {
            char[] temp = aa;
            aa = bb;
            bb = temp;
        }
        StringBuilder sb = new StringBuilder();
        int j = bb.length - 1;
        int carrier = 0;
        for (int i = aa.length - 1; i >= 0; i--) {
            if (aa[i] == '1') carrier++;
            if (j >= 0 && bb[j] == '1') carrier++;
            if (carrier % 2 == 1) sb.append(1);
            else sb.append(0);
            carrier /= 2;
            j--;
        }
        if (carrier == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
