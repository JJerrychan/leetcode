//Given an integer array nums, in which exactly two elements appear only once 
//and all the other elements appear exactly twice. Find the two elements that 
//appear only once. You can return the answer in any order. 
//
// You must write an algorithm that runs in linear runtime complexity and uses 
//only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,3,2,5]
//Output: [3,5]
//Explanation:  [5, 3] is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0]
//Output: [-1,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [0,1]
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each integer in nums will appear twice, only two integers will appear once. 
// 
//
// Related Topics Array Bit Manipulation 👍 5197 👎 216


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) set.remove(n);
            else set.add(n);
        }
        int[] ans = new int[2];
        int i = 0;
        for (int n : set) {
            ans[i++] = n;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
