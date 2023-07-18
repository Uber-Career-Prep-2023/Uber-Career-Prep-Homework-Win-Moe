public class TempA4Q1Trie {
    /*
    struct TrieNode {
   vector<struct TrieNode *> children; // a (resizable or fixed size) array of size 26
   bool validWord; // boolean to indicate if this node marks the end of a word
};

class Trie {
  struct TrieNode* root;

  void insert(string word); // adds a word to the trie
  bool isValidWord(string word); // returns a boolean indicating whether word is in the trie
  void remove(string word); // removes word, from the trie & deletes unused nodes
}
     */

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean validWord;
    }

    // temp getting numbers
    private int charToInt(char c) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // loop through see which index character is, if not throw error
        for (int i = 0; i < alphabet.length(); i++) {
            if (c == alphabet.charAt(i)) {
                return i;
            }
        }
        throw new RuntimeException("Invalid character in trie");
    }

    private TrieNode root = new TrieNode();
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            // integer index
            int index = charToInt(currChar);
            TrieNode next = curr.children[index];

            // if no trieNode, create new, else already in children by default
            if (next == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];

            // if last index, make validWord true
            if (i == word.length()-1) {
                curr.validWord = true;
            }
        }
    }
    public boolean isValidWord(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children[charToInt(word.charAt(i))];
            if (curr == null) {
                return false;
            }
        }
        return curr.validWord;
    }

    public void remove(String word) {
        if (!isValidWord(word)) {
            return;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children[charToInt(word.charAt(i))];

            // if all null or not
            if (curr.children.length == 0) {
                /** gotta fix this */
            } else {
                curr.validWord = false;
            }
        }
    }

    public static void main(String[] args) {
        TempA4Q1Trie t = new TempA4Q1Trie();
        t.insert("wow");
        t.insert("wah");
        t.insert("wall");
        t.insert("gay");
        t.insert("gayer");
        t.insert("");

        // true true
        System.out.println(t.isValidWord("wow"));
        System.out.println(t.isValidWord("gay"));
        System.out.println(t.isValidWord(""));
        // false
        System.out.println(t.isValidWord("wal"));

        // throw exception
        t.insert("124");
        t.insert("WOW");
    }
}
