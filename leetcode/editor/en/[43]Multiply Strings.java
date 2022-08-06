//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// Related Topics Math String Simulation 👍 4836 👎 1980


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Character.getNumericValue(num1.charAt(i));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = Character.getNumericValue(num2.charAt(j));
                int mul = n1 * n2;
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
