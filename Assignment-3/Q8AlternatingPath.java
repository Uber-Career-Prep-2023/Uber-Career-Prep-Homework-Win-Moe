import java.lang.reflect.Array;
import java.util.*;

// Queue, Adjacency List, BFS
// Time Complexity: O(V + E) - complexity of dfs bfs also increases linearly with the queues
// Space Complexity: O(V?) - bfs
// worst case is all vertices and edges need to be visited

// time: spent well over 5 hours still haven't figured

/*
Question 8: AlternatingPath
Given an origin and a destination in a directed graph in which edges can be blue or red, determine the length of the shortest path from the origin to the destination in which the edges traversed alternate in color. Return -1 if no such path exists.

Examples:
[(A, B, "blue"), (A, C, "red"), (B, D, "blue"), (B, E, "blue"), (C, B, "red"), (D, C, "blue"), (A, D, "red"), (D, E, "red"), (E, C, "red")]

Input: origin = A, destination = E
Output: 4 (path: A→D (red), D→C (blue), C→B (red), B→E (blue))

Input: origin = E, destination = D
Output: -1 (only path is: E→C (red), C→B (red), B→D (blue))
 */
public class Q8AlternatingPath {
    static class Info {
        boolean red;
        String node;
        int length;
        public Info(boolean red, String node, int length) {
            this.red  = red;
            this.node = node;
            this.length = length;
        }
    }

    public static int altPath(Map<String, List<String>> redEdges, Map<String, List<String>> blueEdges, String origin, String dest) {
        Queue<Info> queue = new LinkedList<>();
        Map<String, Integer> visitedRed = new HashMap<>();
        Map<String, Integer> visitedBlue = new HashMap<>();

        Info first = new Info(true, origin, 0);
        Info second = new Info(false, origin, 0);
        queue.add(first);
        queue.add(second);

        while (!queue.isEmpty()) {
            Info current = queue.poll();
            boolean isRed = current.red;
            String node = current.node;
            int length = current.length;

            if (node.equals(dest)) {
                return length;
            }

            if (isRed) {
                if (redEdges.get(node) != null) {
                    for (String r : redEdges.get(node)) {
                        if (!visitedRed.containsKey(r) || visitedRed.get(r) > length + 1) {
                            visitedRed.put(r, length + 1);
                            queue.add(new Info(!isRed, r, length + 1));
                        }
                    }
                }
            } else {
                if (blueEdges.get(node) != null) {
                    for (String b : blueEdges.get(node)) {
                        if (!visitedBlue.containsKey(b) || visitedBlue.get(b) > length + 1) {
                            visitedBlue.put(b, length + 1);
                            queue.add(new Info(!isRed, b, length + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        /*
        [(A, B, "blue"), (A, C, "red"), (B, D, "blue"), (B, E, "blue"), (C, B, "red"), (D, C, "blue"), (A, D, "red"), (D, E, "red"), (E, C, "red")]

Input: origin = A, destination = E
Output: 4 (path: A→D (red), D→C (blue), C→B (red), B→E (blue))

Input: origin = E, destination = D
Output: -1 (only path is: E→C (red), C→B (red), B→D (blue))
         */

        Map<String, List<String>> redEdges = new HashMap<>();
        Map<String, List<String>> blueEdges = new HashMap<>();

        redEdges.put("A", new ArrayList<>(Arrays.asList("C", "D")));
        redEdges.put("C", new ArrayList<>(Arrays.asList("B")));
        redEdges.put("D", new ArrayList<>(Arrays.asList("E")));
        redEdges.put("E", new ArrayList<>(Arrays.asList("C")));

        blueEdges.put("A", new ArrayList<>(Arrays.asList("B")));
        blueEdges.put("B", new ArrayList<>(Arrays.asList("D", "E")));
        blueEdges.put("D", new ArrayList<>(Arrays.asList("C")));

        System.out.println(altPath(redEdges, blueEdges, "A", "E")); // Should output 4
        System.out.println(altPath(redEdges, blueEdges, "E", "D")); // Should output -1
    }
}

