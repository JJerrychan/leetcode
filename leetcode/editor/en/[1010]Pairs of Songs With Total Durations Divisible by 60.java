//You are given a list of songs where the iᵗʰ song has a duration of time[i] 
//seconds. 
//
// Return the number of pairs of songs for which their total duration in 
//seconds is divisible by 60. Formally, we want the number of indices i, j such that i < 
//j with (time[i] + time[j]) % 60 == 0. 
//
// 
// Example 1: 
//
// 
//Input: time = [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
// 
//
// Example 2: 
//
// 
//Input: time = [60,60,60]
//Output: 3
//Explanation: All three pairs have a total duration of 120, which is divisible 
//by 60.
// 
//
// 
// Constraints: 
//
// 
// 1 <= time.length <= 6 * 10⁴ 
// 1 <= time[i] <= 500 
// 
//
// Related Topics Array Hash Table Counting 👍 3872 👎 152


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] freq = new long[60];
        for (int t : time) {
            int remind = t % 60;
            freq[remind]++;
        }
        int ans = 0;
        for (int i = 1; i < freq.length / 2; i++) {
            ans += (freq[i] * freq[freq.length - i]);
        }
        ans += freq[30] * (freq[30] - 1) / 2;
        ans += freq[0] * (freq[0] - 1) / 2;
        ;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
