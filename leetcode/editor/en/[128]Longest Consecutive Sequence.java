//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Union Find 👍 16813 👎 720


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curr = n, length = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
