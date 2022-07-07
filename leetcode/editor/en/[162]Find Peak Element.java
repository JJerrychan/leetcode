//A peak element is an element that is strictly greater than its neighbors. 
//
// Given a 0-indexed integer array nums, find a peak element, and return its 
//index. If the array contains multiple peaks, return the index to any of the peaks. 
//
//
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is 
//always considered to be strictly greater than a neighbor that is outside the 
//array. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index 
//number 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak 
//element is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
// Related Topics Array Binary Search 👍 6512 👎 3835


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement(int[] nums) {
        /*int prev = 0;
        int mid = 1;
        int next = 2;
        while (next < nums.length) {
            if (nums[mid] > nums[prev] && nums[mid] > nums[next]) return mid;
            prev++;
            mid++;
            next++;
        }
        if (nums.length > 1 && nums[0] > nums[1]) return 0;
        else return nums.length - 1;*/
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else r = mid;
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
