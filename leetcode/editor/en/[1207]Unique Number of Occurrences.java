//Given an array of integers arr, return true if the number of occurrences of 
//each value in the array is unique or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two 
//values have the same number of occurrences. 
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
//
// Related Topics Array Hash Table 👍 5307 👎 146


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            count.put(a, count.getOrDefault(a, 0)+1);
        }
        HashSet<Integer> occur = new HashSet<>();
        for (int i : count.values()) {
            if (occur.contains(i)) return false;
            else occur.add(i);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
