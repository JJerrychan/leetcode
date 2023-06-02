//You are given an array of variable pairs equations and an array of real 
//numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai 
/// Bi = values[i]. Each Ai or Bi is a string that represents a single variable. 
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the 
//jᵗʰ query where you must find the answer for Cj / Dj = ?. 
//
// Return the answers to all queries. If a single answer cannot be determined, 
//return -1.0. 
//
// Note: The input is always valid. You may assume that evaluating the queries 
//will not result in division by zero and that there is no contradiction. 
//
// 
// Example 1: 
//
// 
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a",
//"c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation: 
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// Example 2: 
//
// 
//Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//Output: [3.75000,0.40000,5.00000,0.20000]
// 
//
// Example 3: 
//
// 
//Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"]
//,["a","c"],["x","y"]]
//Output: [0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj consist of lower case English letters and digits. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Graph Shortest Path 👍 8140 👎 723


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0), b = equation.get(1);
            double value = values[i];
            graph.putIfAbsent(a, new HashMap<String, Double>());
            graph.putIfAbsent(b, new HashMap<String, Double>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0), b = query.get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) ans[i] = -1;
            else if (a.equals(b)) ans[i] = 1;
            else ans[i] = dfs(graph, new HashSet<>(), a, b, 1);
        }
        return ans;
    }

    double dfs(HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited, String curr, String target, double product) {
        visited.add(curr);
        HashMap<String, Double> neighbors = graph.get(curr);
        double ans = -1;
        if (neighbors.containsKey(target)) return product * neighbors.get(target);
        else {
            for (String key : neighbors.keySet()) {
                if (!visited.contains(key)) {
                    ans = dfs(graph, visited, key, target, product * neighbors.get(key));
                    if (ans != -1) break;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
