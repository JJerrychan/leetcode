//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 5941 👎 404


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean inserted = false;

        for (int[] x : intervals) {
            if (inserted) {
                list.add(x);
            } else if (end < x[0]) {
                list.add(new int[]{start, end});
                list.add(x);
                inserted = true;
            } else if (start > x[1]) {
                list.add(x);
            } else {
                start = Math.min(start, x[0]);
                end = Math.max(end, x[1]);
            }
        }

        if (!inserted) list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
