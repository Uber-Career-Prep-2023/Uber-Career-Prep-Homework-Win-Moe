import java.util.HashSet;
import java.util.Set;

public class Q6WordBreak {
    public boolean wordBreak(Set<String> dict, String word) {

        Q1Trie trie = new Q1Trie();
        for (String s : dict) {
            trie.insert(s);
        }

        return wBHelper(dict, word, trie, trie.root, 0);
    }

    public boolean wBHelper(Set<String> dict, String word, Q1Trie trie, Q1Trie.TrieNode currNode, int currIndex) {
        if (currIndex == word.length()) return true;

        for (int i = currIndex; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int indexOfCurrChar = trie.charToInt(currChar);
            // if exists in root
            if (currNode.children[indexOfCurrChar] != null) {
                currNode = currNode.children[indexOfCurrChar];
                if (currNode.validWord == true) {
                    if (i < word.length()-1 && currNode.children[trie.charToInt(word.charAt(i+1))] != null) {
                        return wBHelper(dict, word, trie, currNode, i)
                                || wBHelper(dict, word, trie, currNode, i+1);
                    } else {
                        currNode = trie.root;
                    }
                }
            } else {
                // try smth else
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();

        stringSet.add("elf".toLowerCase());
        stringSet.add("go".toLowerCase());
        stringSet.add("golf".toLowerCase());
        stringSet.add("man".toLowerCase());
        stringSet.add("manatee".toLowerCase());
        stringSet.add("not".toLowerCase());
        stringSet.add("note".toLowerCase());
        stringSet.add("pig".toLowerCase());
        stringSet.add("quip".toLowerCase());
        stringSet.add("tee".toLowerCase());
        stringSet.add("teen".toLowerCase());

        Q6WordBreak wb = new Q6WordBreak();
        // true case
        System.out.println(wb.wordBreak(stringSet, "gogolfgogogogogolf"));
        System.out.println(wb.wordBreak(stringSet, "mangopig"));
        System.out.println(wb.wordBreak(stringSet, "notnotepigteeteen"));
        System.out.println(wb.wordBreak(stringSet, "mangopig"));
        System.out.println(wb.wordBreak(stringSet, "manatee"));

        // false
        System.out.println(wb.wordBreak(stringSet, ""));
        System.out.println(wb.wordBreak(stringSet, "tego"));
        System.out.println(wb.wordBreak(stringSet, "pigger"));
        System.out.println(wb.wordBreak(stringSet, "quipig"));
        System.out.println(wb.wordBreak(stringSet, "1234")); // throws error because of the method
    }
}
