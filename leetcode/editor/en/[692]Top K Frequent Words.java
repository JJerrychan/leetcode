//Given an array of strings words and an integer k, return the k most frequent 
//strings. 
//
// Return the answer sorted by the frequency from highest to lowest. Sort the 
//words with the same frequency by their lexicographical order. 
//
// 
// Example 1: 
//
// 
//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
//Explanation: "i" and "love" are the two most frequent words.
//Note that "i" comes before "love" due to a lower alphabetical order.
// 
//
// Example 2: 
//
// 
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
// k = 4
//Output: ["the","is","sunny","day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
//with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] consists of lowercase English letters. 
// k is in the range [1, The number of unique words[i]] 
// 
//
// 
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space? 
// Related Topics Hash Table String Trie Sorting Heap (Priority Queue) Bucket 
//Sort Counting 👍 4634 👎 254


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) > hashMap.get(o2)) return -1;
                else if (hashMap.get(o1) == hashMap.get(o2)) {
                    if (o1.compareTo(o2) > 0) return 1;
                    else return -1;
                } else return 1;
            }
        });
        for (String word : words) {
            if (hashMap.containsKey(word)) hashMap.put(word, hashMap.get(word) + 1);
            else hashMap.put(word, 1);
        }
        for (String s : hashMap.keySet()) {
            heap.add(s);
        }
        for (int i = 0; i < k; i++) {
            list.add(heap.poll());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
