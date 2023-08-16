import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2Boggle {
    /*
    Technique: Trie as a parameter
    Time Complexity: O(n^m + m^n) where n is length of arr, because it could be checking every possible combination and direction
    Space Complexity: O(m*n) where m is length of arr, n is length of arr[0]
     */
    public Set<String> boggle(char[][] board, Set<String> dictionary) {
        Set<String> results = new HashSet<>();
        if (board == null) {
            return results;
        }

        int currLen = 3;
        for (int i = currLen; i < 10; i++) {
            helper(board, results, i, dictionary);
        }
        return results;
    }

    public void helper(char[][] board, Set<String> results, int currLen, Set<String> dictionary) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // traverse starting here
                traverse(board, i, j, results, currLen, 0, "", dictionary);
            }
        }
    }

    public void traverse(char[][] board, int i, int j, Set<String> results, int currLen, int currIndex, String s, Set<String> dictionary) {
        // copy boolean
        if (currLen == currIndex && dictionary.contains(s)) {
            //
            results.add(s);
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return;
        }
        char temp = board[i][j];
        s += temp;
        // do visited
        board[i][j] = '*';
        currIndex += 1;
        // left right bottom up
        traverse(board, i-1, j, results, currLen, currIndex, s, dictionary);
        traverse(board, i+1, j, results, currLen, currIndex, s, dictionary);
        traverse(board, i, j-1, results, currLen, currIndex, s, dictionary);
        traverse(board, i, j+1, results, currLen, currIndex, s, dictionary);
        traverse(board, i-1, j-1, results, currLen, currIndex, s, dictionary);
        traverse(board, i+1, j-1, results, currLen, currIndex, s, dictionary);
        traverse(board, i-1, j+1, results, currLen, currIndex, s, dictionary);
        traverse(board, i+1, j+1, results, currLen, currIndex, s, dictionary);
        board[i][j] = temp;
    }

    public static void main(String[] args) {
        Q2Boggle q = new Q2Boggle();
        char[][] board = {
                {'a', 'd', 'e'},
                {'r', 'c', 'p'},
                {'l', 'a', 'y'}
        };
        Set<String> stringSet = new HashSet<>();

        stringSet.add("ace");
        stringSet.add("gape");
        stringSet.add("tray");
        stringSet.add("may");
        stringSet.add("map");
        stringSet.add("clap");
        stringSet.add("lap");
        stringSet.add("tape");
        stringSet.add("pay");
        stringSet.add("lay");
        stringSet.add("trap");
        stringSet.add("rap");
        stringSet.add("clay");
        stringSet.add("cape");
        stringSet.add("ray");
        stringSet.add("trace");
        stringSet.add("lace");
        stringSet.add("pace");
        stringSet.add("yap");
        stringSet.add("grape");
        stringSet.add("mace");
        stringSet.add("tap");

        System.out.println(q.boggle(board, stringSet));
    }

}
