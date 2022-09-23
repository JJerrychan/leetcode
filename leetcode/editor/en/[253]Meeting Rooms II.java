//Given an array of meeting time intervals intervals where intervals[i] = [
//starti, endi], return the minimum number of conference rooms required. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2
// 
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
//
// Related Topics Array Two Pointers Greedy Sorting Heap (Priority Queue) 
//Prefix Sum 👍 6004 👎 128


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int room = 0;
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int sp = 0, ep = 0;
        while (sp < intervals.length) {
            if (start[sp] >= end[ep]) {
                room--;
                ep++;
            }
            room++;
            sp++;
        }
        return room;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
