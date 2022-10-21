//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
//
// Related Topics Hash Table String Design Trie 👍 8378 👎 101


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    Trie[] node;
    boolean isEnd;

    public Trie() {
        node = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie curr = this;
        for (char w : word.toCharArray()) {
            if (curr.node[w - 'a'] == null) curr.node[w - 'a'] = new Trie();
            curr = curr.node[w - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (char w : word.toCharArray()) {
            if (curr.node[w - 'a'] == null) return false;
            curr = curr.node[w - 'a'];
        }
        return curr.isEnd ? true : false;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char w : prefix.toCharArray()) {
            if (curr.node[w - 'a'] == null) return false;
            curr = curr.node[w - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
