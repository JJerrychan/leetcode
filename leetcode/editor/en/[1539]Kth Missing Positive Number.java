/**
 * Given an array arr of positive integers sorted in a strictly increasing order,
 * and an integer k.
 * <p>
 * Return the kᵗʰ positive integer that is missing from this array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5ᵗʰ
 *  missing positive integer is 9.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2ⁿᵈ missing
 * positive integer is 6.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve this problem in less than O(n) complexity?
 * <p>
 * Related Topics Array Binary Search 👍 7605 👎 542
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int rest = arr[mid] - mid - 1;
            if (rest < k) l = mid + 1;
            else r = mid;
        }
        return k + l;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
