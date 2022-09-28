//Given an array of points where points[i] = [xi, yi] represents a point on the 
//X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//
// The distance between two points on the X-Y plane is the Euclidean distance (
//i.e., √(x1 - x2)² + (y1 - y2)²). 
//
// You may return the answer in any order. The answer is guaranteed to be 
//unique (except for the order that it is in). 
//
// 
// Example 1: 
// 
// 
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
//
// Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority 
//Queue) Quickselect 👍 6560 👎 239


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int o1s = o1[0] * o1[0] + o1[1] * o1[1];
                int o2s = o2[0] * o2[0] + o2[1] * o2[1];
                return o1s - o2s;
            }
        });
        for (int[] p : points) queue.add(p);
        ArrayList<int[]> list = new ArrayList<>();
        while (k > 0) {
            list.add(queue.poll());
            k--;
        }
        return list.toArray(new int[k][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
