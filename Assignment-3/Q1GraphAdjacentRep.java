import java.util.*;

public class Q1GraphAdjacentRep {
    // Question 1: Build an Adjacency List/Set Representation of a Graph

    /**
     * Given an array of pairs of values representing edges in an unweighted graph,
     * create the equivalent adjacency list/set representation (a map from element to a list or set of elements).
     * Pairs represent directed edges: (A, B) means there is an edge from A to B.
     * If the pair (B, A) is also provided then there is an undirected edge between A and B.
     * For simplicity, you may assume that each node of the graph stores an integer
     * rather than a generic data type and that the elements are distinct.
     * // Build graph representation. You can also use an array rather than a set
     * map<int, set<int>> adjacencySet(array<pair<int, int>> edges);
     * // Example
     * Input: [(1, 2), (2, 3), (1, 3), (3, 2), (2, 0)]
     * Output:
     * {
     *     0: []
     *     1: [2, 3]
     *     2: [0, 3]
     *     3: [2]
     * }
     *
     * bool bfs(int target, map<int, set<int>> graph);
     * bool dfs(int target, map<int, set<int>> graph);
     * array<int> topologicalSort(map<int, set<int>> graph);
     */

    public static Map<Integer, Set<Integer>> adjacencySet(int[][] edges) {
        // input edges from one int to another int in a map
        // by default the output map is empty, int maps to set of integers adjacent to it
        // if empty, output that empty map
        // else
        // for loop through the keyset of source and add each value to the set of the source in integer to set map
        // ** using treemap and treeset to break ties by order
        if (edges == null) {
            return null;
        }

        Map<Integer, Set<Integer>> adjSet = new TreeMap<Integer, Set<Integer>>();
        for (int[] pair : edges) {
            // put hashsets for each source even if it doesnt have anything
            // including receiving edges because they are still vertices on the adjacency set
            int source = pair[0];
            int target = pair[1];
            adjSet.put(source, new TreeSet<>());
            adjSet.put(target, new TreeSet<>());
        }

        for (int[] pair : edges) {
            int source = pair[0];
            int target = pair[1];
            Set<Integer> setOfVerticeToAddTo = adjSet.get(source);
            setOfVerticeToAddTo.add(target);
        }

        //test
        System.out.println(adjSet);

        return adjSet;
    }

    /**
     * Implement a basic DFS and BFS searching for a target value
     * and a topological sort (using either DFS or Kahn’s algorithm).
     */

    // DFS inputs the adjSet, returns whether the target value is found
    public static boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        // nullcase
        if (graph == null) {
            return false;
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> vertices = new ArrayList<>();

        for (int i : graph.keySet()) {
            // to check whether not everything is visited;
            // instead of boolean array, we map the value to the boolean
            // boolean[] visited = new boolean[size];
            visited.put(i, false);
            vertices.add(i);
        }

        int counter = 0;
        int firstNum = vertices.get(0);

        // queue nodes to visit
        boolean allVisited = false;
        Queue<Integer> queue = new LinkedList<>();

        for (int adjToFirstNum : graph.get(firstNum)) {
            queue.add(adjToFirstNum);
        }
        visited.put(firstNum, true);

        while (!queue.isEmpty() || !allVisited) {
            int nextNum;
            if (queue.isEmpty()) {
                counter += 1;
                nextNum = vertices.get(counter);
            } else {
                nextNum = queue.remove();
            }
            if (target == nextNum) {
                System.out.println(true);
                return true;
            }
            // if the number is not visited, add to the queue;
            if (visited.get(nextNum) == false) {
                for (int adjToNextNum : graph.get(nextNum)) {
                    queue.add(adjToNextNum);
                }
                visited.put(nextNum, true);
            }

            // check whether all nodes are all visited
            for (int i : visited.keySet()) {
                allVisited = true;
                if (visited.get(i) == false) {
                    allVisited = false;
                    break;
                }
            }
        }
        System.out.println(false);
        return false;
    }

    public static void main(String[] args) {
         int[][] edges = new int[5][2];
         edges[0] = new int[]{1,2};
         edges[1] = new int[]{2,3};
         edges[2] = new int[]{1,3};
         edges[3] = new int[]{3,2};
         edges[4] = new int[]{2,0};
        Map<Integer, Set<Integer>> graph = adjacencySet(edges);

        bfs(99, graph);
        bfs(2, null);
        bfs(2, graph);
        bfs(0, graph);
        bfs(1, graph);
        bfs(3, graph);
        bfs(-88, graph);
    }
}