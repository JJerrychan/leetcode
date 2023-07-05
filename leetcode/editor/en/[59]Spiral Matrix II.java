//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics Array Matrix Simulation 👍 5777 👎 236


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int elem = 1;
        int row = n - 1, col = n - 1;
        int rowBegin = 0, colBegin = 0;
        do {
            for (int i = colBegin; i <= col; i++)
                matrix[rowBegin][i] = elem++;
            rowBegin++;
            for (int i = rowBegin; i <= row; i++)
                matrix[i][col] = elem++;
            col--;
            for (int i = col; i >= colBegin; i--)
                matrix[row][i] = elem++;
            row--;
            for (int i = row; i >= rowBegin; i--)
                matrix[i][colBegin] = elem++;
            colBegin++;
        } while (rowBegin <= row && colBegin <= col);
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
