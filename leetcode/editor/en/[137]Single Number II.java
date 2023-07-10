//Given an integer array nums where every element appears three times except 
//for one, which appears exactly once. Find the single element and return it. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,3,2]
//Output: 3
// 
// Example 2: 
// Input: nums = [0,1,0,1,0,1,99]
//Output: 99
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each element in nums appears exactly three times except for one element 
//which appears once. 
// 
//
// Related Topics Array Bit Manipulation 👍 7044 👎 618


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
