//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 13013 👎 330


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            else {
                ans[0] = mid;
                ans[1] = mid;
                int first = mid - 1, last = mid + 1;
                while (first >= 0 && nums[first] == target) {
                    ans[0] = first;
                    first--;
                }
                while (last < nums.length && nums[last] == target) {
                    ans[1] = last;
                    last++;
                }
                return ans;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
