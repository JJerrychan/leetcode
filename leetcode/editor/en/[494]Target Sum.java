//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which 
//evaluates to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be 
//target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics Array Dynamic Programming Backtracking 👍 9160 👎 312


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
//DP
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (total < target || -total > target) return 0;
        int[][] dp = new int[nums.length + 1][total * 2 + 1];
        int leftBound = 0, rightBound = total * 2;
        dp[0][total] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < rightBound + 1; j++) {
                if (j + nums[i - 1] <= rightBound) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= leftBound) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][total + target];
    }
}
//dfs
/*class Solution {
    int ans = 0;

    void backtracking(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target) ans++;
            return;
        }
        backtracking(nums, target, idx + 1, sum + nums[idx]);
        backtracking(nums, target, idx + 1, sum - nums[idx]);
    }

    public int findTargetSumWays(int[] nums, int target) {

        backtracking(nums, target, 0, 0);
        return ans;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
