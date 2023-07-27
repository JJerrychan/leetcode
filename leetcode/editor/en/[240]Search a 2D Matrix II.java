//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search Divide and Conquer Matrix 👍 10804 👎 174


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[0].length - 1;
            if (matrix[i][0] > target || matrix[i][right] < target) continue;
            while (left <= right) {
                int mid = left - (left - right) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] > target) right -= 1;
                else left += 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
