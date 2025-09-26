import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 * length is 4.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 2500
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 * <p>
 * Related Topics Array Binary Search Dynamic Programming 👍 22242 👎 492
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        int ans = 0;
        for (int len : dp) ans = Math.max(ans, len);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
