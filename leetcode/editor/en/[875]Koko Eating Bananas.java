import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has piles[
 * i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses
 * some pile of bananas and eats k bananas from that pile. If the pile has less
 * than k bananas, she eats all of them instead and will not eat any more bananas
 * during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= piles.length <= 10⁴
 * piles.length <= h <= 10⁹
 * 1 <= piles[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics Array Binary Search 👍 9964 👎 552
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int amt = 0;
            for (int i : piles) {
                amt += i / mid;
                if (i % mid > 0) amt++;
            }
            if (amt <= h) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
