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
        Map<String, Set<Boolean>> visited = new HashMap<>();
        for (String s : redEdges.keySet()) {
            visited.put(s, new HashSet<>());
        }
        for (String ss : blueEdges.keySet()) {
            visited.put(ss, new HashSet<>());
        }

        int lowest = Integer.MAX_VALUE;

        Info first = new Info(true, origin, 1);
        Info second = new Info(false, origin, 1);
        queue.add(first);
        queue.add(second);
        visited.get(origin).add(true);
        visited.get(origin).add(false);

        while (queue.size() > 0) {
            Info toPop = queue.poll();
            boolean red = toPop.red;
            String node = toPop.node;
            int length = toPop.length;

            if (!red && redEdges.get(node) != null) {
                for (String r : redEdges.get(node)) {
                    if (visited.get(r).size() < 2) {
                        System.out.println(node + " to " + r + " red");
                        if (r.equals(dest)) {
                            lowest = length;
                        }
                        visited.get(r).add(true);
                        queue.add(new Info(!red, r, length + 1));
                    }
                }
            }

            if (red && blueEdges.get(node) != null) {
                for (String b : blueEdges.get(node)) {
                    if (visited.get(b).size() < 2) {
                        System.out.println(node + " to " + b + " blue");
                        if (b.equals(dest)) {
                            lowest = length;
                        }
                        visited.get(b).add(false);
                        queue.add(new Info(red, b, length + 1));
                    }
                }
            }
        }

        if (lowest == Integer.MAX_VALUE) {
            return -1;
        }
        return lowest;
    }
    public static void main(String[] args) {
        /*
        [(A, B, "blue"), (A, C, "red"), (B, D, "blue"), (B, E, "blue"), (C, B, "red"), (D, C, "blue"), (A, D, "red"), (D, E, "red"), (E, C, "red")]

Input: origin = A, destination = E
Output: 4 (path: A→D (red), D→C (blue), C→B (red), B→E (blue))

Input: origin = E, destination = D
Output: -1 (only path is: E→C (red), C→B (red), B→D (blue))
         */

        Map<String, List<String>> redEdge = new HashMap<>();
        Map<String, List<String>> blueEdge = new HashMap<>();
        redEdge.put("A", Arrays.asList("C"));
        redEdge.put("C", Arrays.asList("B"));
        redEdge.put("A", Arrays.asList("D"));
        redEdge.put("D", Arrays.asList("E"));
        redEdge.put("E", Arrays.asList("C"));
        blueEdge.put("A", Arrays.asList("B"));
        blueEdge.put("B", Arrays.asList("D"));
        blueEdge.put("B", Arrays.asList("E"));
        blueEdge.put("D", Arrays.asList("C"));
        blueEdge.put("A", Arrays.asList("B"));

        System.out.println(altPath(redEdge, blueEdge, "A", "E"));
        System.out.println(altPath(redEdge, blueEdge, "E", "D"));
    }
}

