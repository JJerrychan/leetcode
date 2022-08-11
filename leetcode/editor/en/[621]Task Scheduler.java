//Given a characters array tasks, representing the tasks a CPU needs to do, 
//where each letter represents a different task. Tasks could be done in any order. 
//Each task is done in one unit of time. For each unit of time, the CPU could 
//complete either one task or just be idle. 
//
// However, there is a non-negative integer n that represents the cooldown 
//period between two same tasks (the same letter in the array), that is that there 
//must be at least n units of time between any two same tasks. 
//
// Return the least number of units of times that the CPU will take to finish 
//all the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] is upper-case English letter. 
// The integer n is in the range [0, 100]. 
// 
//
// Related Topics Array Hash Table Greedy Sorting Heap (Priority Queue) 
//Counting 👍 7012 👎 1370


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (char t : tasks) {
            time++;
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        queue.addAll(map.values());
        int maxFreq = queue.poll();
        int totalIdle = (maxFreq - 1) * n;
        while (!queue.isEmpty()) {
            int currFreq = queue.poll();
            totalIdle -= currFreq;
            if (currFreq == maxFreq) totalIdle++;
        }
        return totalIdle > 0 ? time + totalIdle : time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
