//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics Array Matrix Simulation 👍 8219 👎 885


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int rowBegin = 0, colBegin = 0;
        do {
            for (int i = colBegin; i <= col; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= row; i++) {
                list.add(matrix[i][col]);
            }
            col--;
            if (rowBegin <= row) {
                for (int i = col; i >= colBegin; i--) {
                    list.add(matrix[row][i]);
                }
            }
            row--;
            if (colBegin <= col) {
                for (int i = row; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        } while (rowBegin <= row && colBegin <= col);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
