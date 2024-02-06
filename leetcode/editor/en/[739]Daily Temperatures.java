import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the iᵗʰ day to get a warmer temperature. If there is no future day for which
 * this is possible, keep answer[i] == 0 instead.
 * <p>
 * <p>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= temperatures.length <= 10⁵
 * 30 <= temperatures[i] <= 100
 * <p>
 * <p>
 * Related Topics Array Stack Monotonic Stack 👍 12776 👎 298
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int today = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < today) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
        //my solution
        /*int[] ans = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            int today = temperatures[i];
            while (!stack.isEmpty()) {
                int[] past = stack.pop();
                if (past[0] < today) ans[past[1]] = i - past[1];
                else {
                    stack.add(past);
                    break;
                }
            }
            stack.add(new int[]{today, i});
        }
        while (!stack.isEmpty()) {
            int[] past = stack.pop();
            ans[past[1]] = 0;
        }
        return ans;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
