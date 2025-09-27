//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, 
//numsr] of which the sum is greater than or equal to target. If there is no such 
//subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem 
//constraint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another 
//solution of which the time complexity is O(n log(n)). Related Topics Array Binary 
//Search Sliding Window Prefix Sum 👍 7043 👎 204


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == nums.length + 1 ? 0 : min;
    }

/*    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int length = nums.length + 1;
        int i = 0, j = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                length = Math.min(length, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return length == nums.length + 1 ? 0 : length;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
