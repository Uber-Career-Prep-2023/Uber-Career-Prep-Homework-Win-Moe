public class Q1Trie {
    /*
    How to implement a Trie Data Structure?
Create a root node with the help of TrieNode() constructor.
Store a collection of strings that have to be inserted in the trie in a vector of strings say, arr.
Inserting all strings in Trie with the help of the insert() function,
Search strings with the help of search() function.
     */

    /*
    Insert Operation in Trie:
Inserting a key into Trie is a simple approach.

Every character of the input key is inserted as an individual Trie node. Note that the children is an array of pointers (or references) to next-level trie nodes.
The key character acts as an index to the array children.
If the input key is new or an extension of the existing key, construct non-existing nodes of the key, and mark the end of the word for the last node.
If the input key is a prefix of the existing key in Trie, Simply mark the last node of the key as the end of a word.
     */

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
        rem(word, 0, root);
    }

    public void rem(String word, int index, TrieNode curr) {
        if (index == word.length()) {
            curr.validWord = false;
            return;
        }
        char c = word.charAt(index);
        TrieNode child = curr.children[charToInt(c)];
    }

    public static void main(String[] args) {
        Q1Trie s = new Q1Trie();
        s.insert("ab");
        s.insert("bc");
        System.out.println(s.isValidWord("a")); // false
        System.out.println(s.isValidWord("ab")); // true
        s.remove("a");
        s.remove("ab");
        System.out.println(s.isValidWord("a")); // false
        System.out.println(s.isValidWord("ab")); // false

        s.insert("bcdef");
        s.insert("bcd");
        s.remove("bcd");
        System.out.println(s.isValidWord("bcdef")); // true
        System.out.println(s.isValidWord("bcd")); // false

        System.out.println("test2");
        System.out.println();

        Q1Trie t = new Q1Trie();
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

        t.remove("wow");
        System.out.println(t.isValidWord("wal")); // this is not working, it is supposed to output true because wal is still there

        // throw exception
        t.insert("124");
        t.insert("WOW");
    }
}
