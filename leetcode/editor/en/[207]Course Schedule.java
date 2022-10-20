//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 11646 👎 450


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        for (int i = 0; i < numCourses; i++) {
            if (!isValid(i, list, visited)) return false;
        }
        return true;
    }

    boolean isValid(int node, List<List<Integer>> list, int[] visited) {
        if (visited[node] == 1) return false;
        if (visited[node] == 2) return true;
        visited[node] = 1;
        for (int n : list.get(node)) {
            if (!isValid(n, list, visited)) return false;
        }
        visited[node] = 2;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
