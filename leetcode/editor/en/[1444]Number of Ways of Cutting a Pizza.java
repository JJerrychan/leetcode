//Given a rectangular pizza represented as a rows x cols matrix containing the 
//following characters: 'A' (an apple) and '.' (empty cell) and given the integer 
//k. You have to cut the pizza into k pieces using k-1 cuts. 
//
// For each cut you choose the direction: vertical or horizontal, then you 
//choose a cut position at the cell boundary and cut the pizza into two pieces. If you 
//cut the pizza vertically, give the left part of the pizza to a person. If you 
//cut the pizza horizontally, give the upper part of the pizza to a person. Give 
//the last piece of pizza to the last person. 
//
// Return the number of ways of cutting the pizza such that each piece contains 
//at least one apple. Since the answer can be a huge number, return this modulo 10
//^9 + 7. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: pizza = ["A..","AAA","..."], k = 3
//Output: 3 
//Explanation: The figure above shows the three ways to cut the pizza. Note 
//that pieces must contain at least one apple.
// 
//
// Example 2: 
//
// 
//Input: pizza = ["A..","AA.","..."], k = 3
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: pizza = ["A..","A..","..."], k = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza consists of characters 'A' and '.' only. 
// 
//
// Related Topics Array Dynamic Programming Memoization Matrix 👍 533 👎 20


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ways(String[] pizza, int k) {
        int mod = (int) (1e9 + 7);
        int row = pizza.length, col = pizza[0].length();
        int[][] sum = new int[row + 1][col + 1];
        int[][][] dp = new int[k + 1][row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                sum[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                sum[i][j] += sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1];
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (sum[i][j] >= 1) dp[1][i][j] = 1;
            }
        }

        for (int l = 2; l <= k; l++) {
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {

                    for (int x = i + 1; x < row; x++) {
                        if (sum[i][j] - sum[x][j] > 0) dp[l][i][j] = (dp[l][i][j] + dp[l - 1][x][j]) % mod;
                    }

                    for (int x = j + 1; x < col; x++) {
                        if (sum[i][j] - sum[i][x] > 0) dp[l][i][j] = (dp[l][i][j] + dp[l - 1][i][x]) % mod;
                    }
                }
            }
        }

        return dp[k][0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
