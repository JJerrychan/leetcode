//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like (i.e., buy one and sell one share of the stock multiple times) 
//with the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., 
//cooldown one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics Array Dynamic Programming 👍 9687 👎 340


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int[] stay = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            stay[i] = Math.max(stay[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], stay[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
        }

        return Math.max(stay[prices.length - 1], sell[prices.length - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
