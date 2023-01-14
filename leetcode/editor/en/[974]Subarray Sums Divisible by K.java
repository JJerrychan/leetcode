//Given an integer array nums and an integer k, return the number of non-empty 
//subarrays that have a sum divisible by k. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// Example 2: 
//
// 
//Input: nums = [5], k = 9
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 3926 👎 157


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0, preMod = 0;
        int[] mod = new int[k];
        mod[0] = 1;
        for (int n : nums) {
            preMod = (preMod + n % k + k) % k;
            ans += mod[preMod]++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
