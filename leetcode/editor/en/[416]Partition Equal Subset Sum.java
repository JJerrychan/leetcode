//Given an integer array nums, return true if you can partition the array into 
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 9591 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int subSum = sum / 2;
        boolean[] dp = new boolean[subSum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = subSum; i >= n; i--) {
                dp[i] |= dp[i - n];
            }
        }
        return dp[subSum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
