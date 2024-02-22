import java.util.Arrays;
import java.util.Stack;

/**
 * There are n cars going to the same destination along a one-lane road. The
 * destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n, where
 * position[i] is the position of the iᵗʰ car and speed[i] is the speed of the iᵗʰ
 * car (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it and
 * drive bumper to bumper at the same speed. The faster car will slow down to match
 * the slower car's speed. The distance between these two cars is ignored (i.e.,
 * they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and
 * same speed. Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will
 * still be considered as one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each
 * other at 12.
 * The car starting at 0 does not catch up to any other car, so it is a fleet by
 * itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each
 * other at 6. The fleet moves at speed 1 until it reaches target.
 * Note that no other cars meet these fleets before the destination, so the answer
 * is 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: target = 10, position = [3], speed = [3]
 * Output: 1
 * Explanation: There is only one car, hence there is only one fleet.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: target = 100, position = [0,2,4], speed = [4,2,1]
 * Output: 1
 * Explanation:
 * The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each
 * other at 4. The fleet moves at speed 2.
 * Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet,
 * meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == position.length == speed.length
 * 1 <= n <= 10⁵
 * 0 < target <= 10⁶
 * 0 <= position[i] < target
 * All the values of position are unique.
 * 0 < speed[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics Array Stack Sorting Monotonic Stack 👍 3318 👎 871
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(posSpeed, (o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - posSpeed[i][0]) / posSpeed[i][1];
            if (!stack.isEmpty() && time <= stack.peek()) continue;
            else stack.add(time);
        }

        return stack.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
