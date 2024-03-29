//A company is planning to interview 2n people. Given the array costs where 
//costs[i] = [aCosti, bCosti], the cost of flying the iᵗʰ person to city a is aCosti, 
//and the cost of flying the iᵗʰ person to city b is bCosti. 
//
// Return the minimum cost to fly every person to a city such that exactly n 
//people arrive in each city. 
//
// 
// Example 1: 
//
// 
//Input: costs = [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people 
//interviewing in each city.
// 
//
// Example 2: 
//
// 
//Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//Output: 1859
// 
//
// Example 3: 
//
// 
//Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[65
//0,359],[631,42]]
//Output: 3086
// 
//
// 
// Constraints: 
//
// 
// 2 * n == costs.length 
// 2 <= costs.length <= 100 
// costs.length is even. 
// 1 <= aCosti, bCosti <= 1000 
// 
//
// Related Topics Array Greedy Sorting 👍 4346 👎 324


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int total = 0;
        int n = costs.length / 2;
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - b[0] + b[1]);
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
