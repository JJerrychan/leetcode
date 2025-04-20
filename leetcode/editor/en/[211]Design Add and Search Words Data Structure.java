//Design a data structure that supports adding new words and finding if a 
//string matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure 
//that matches word or false otherwise. word may contain dots '.' where dots can 
//be matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 25 
// word in addWord consists of lowercase English letters. 
// word in search consist of '.' or lowercase English letters. 
// There will be at most 2 dots in word for search queries. 
// At most 10⁴ calls will be made to addWord and search. 
// 
//
// Related Topics String Depth-First Search Design Trie 👍 7828 👎 474


//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary currDic = this;
        for (char c : word.toCharArray()) {
            if (currDic.children[c - 'a'] == null) currDic.children[c - 'a'] = new WordDictionary();
            currDic = currDic.children[c - 'a'];
        }
        currDic.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary currDic = this;
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w == '.') {
                for (WordDictionary child : currDic.children) {
                    if (child != null && child.search(word.substring(i + 1))) return true;
                }
                return false;
            }
            if (currDic.children[w - 'a'] == null) return false;
            currDic = currDic.children[w - 'a'];
        }
        return currDic.isEnd ? true : false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
