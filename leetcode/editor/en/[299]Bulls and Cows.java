//You are playing the Bulls and Cows game with your friend. 
//
// You write down a secret number and ask your friend to guess what the number 
//is. When your friend makes a guess, you provide a hint with the following info: 
//
// 
// The number of "bulls", which are digits in the guess that are in the correct 
//position. 
// The number of "cows", which are digits in the guess that are in your secret 
//number but are located in the wrong position. Specifically, the non-bull digits 
//in the guess that could be rearranged such that they become bulls. 
// 
//
// Given the secret number secret and your friend's guess guess, return the 
//hint for your friend's guess. 
//
// The hint should be formatted as "xAyB", where x is the number of bulls and y 
//is the number of cows. Note that both secret and guess may contain duplicate 
//digits. 
//
// 
// Example 1: 
//
// 
//Input: secret = "1807", guess = "7810"
//Output: "1A3B"
//Explanation: Bulls are connected with a '|' and cows are underlined:
//"1807"
//  |
//"7810" 
//
// Example 2: 
//
// 
//Input: secret = "1123", guess = "0111"
//Output: "1A1B"
//Explanation: Bulls are connected with a '|' and cows are underlined:
//"1123"        "1123"
//  |      or     |
//"0111"        "0111"
//Note that only one of the two unmatched 1s is counted as a cow since the non-
//bull digits can only be rearranged to allow one 1 to be a bull.
// 
//
// 
// Constraints: 
//
// 
// 1 <= secret.length, guess.length <= 1000 
// secret.length == guess.length 
// secret and guess consist of digits only. 
// 
//
// Related Topics Hash Table String Counting 👍 1548 👎 1432


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) A++;
            map.put(cs, map.getOrDefault(cs, 0) + 1);
        }
        for (char g : guess.toCharArray()) {
            if (map.containsKey(g)) {
                B++;
                map.put(g, map.get(g) - 1);
                if (map.get(g) == 0) map.remove(g);
            }
        }
        B -= A;
        return A + "A" + B + "B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
