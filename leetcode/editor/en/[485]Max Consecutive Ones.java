//Given a binary array nums, return the maximum number of consecutive 1's in 
//the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
// The maximum number of consecutive 1s is 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1,0,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
// Related Topics Array 👍 2844 👎 403


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (a > b) b = a;
                a = 0;
            }
            if (nums[i] == 1) a++;
        }
        return a > b ? a : b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
