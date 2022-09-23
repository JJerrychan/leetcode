//Given an array of meeting time intervals where intervals[i] = [starti, endi], 
//determine if a person could attend all meetings. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: false
// 
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: true
// 
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁶ 
// 
//
// Related Topics Array Sorting 👍 1627 👎 79


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (start[i + 1] < end[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
