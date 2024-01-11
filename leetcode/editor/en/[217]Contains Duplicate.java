//Given an integer array nums, return true if any value appears at least twice 
//in the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Sorting 👍 5309 👎 970


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            if (set.contains(n)) return true;
            else set.add(n);
        return false;
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            if(hashMap.containsKey(n)){
                return true;
            }
            hashMap.put(n,1);
        }
        return false;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
