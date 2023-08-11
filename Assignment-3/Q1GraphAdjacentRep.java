import java.util.*;

public class Q1GraphAdjacentRep {
    // Question 1: Build an Adjacency List/Set Representation of a Graph
    // entire question took me around 2 hours esp when learning the process of the visited etc.

    public static List<Integer> bfsTracker = new ArrayList<>();
    public static List<Integer> dfsTracker = new ArrayList<>();

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
        if (graph == null) return false;

        // visited, and vertices so that we don't miss any nodes
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> vertices = new ArrayList<>();
        // queue for nodes to visit
        boolean allVisited = false;
        Queue<Integer> queue = new LinkedList<>();


        for (int i : graph.keySet()) {
            // to check whether not everything is visited;
            // instead of boolean array, we map the value to the boolean
            // boolean[] visited = new boolean[size];
            visited.put(i, false);
            vertices.add(i);
        }

        int counter = 0;
        int firstNum = vertices.get(counter);

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
                bfsTracker.add(nextNum);
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

    public static boolean dfs(int target, Map<Integer, Set<Integer>> graph) {
        if (graph == null) return false;

        //create visited and the list of vertices
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> vertices = new ArrayList<>();
        // stack for nodes to visit
        boolean allVisited = false;
        Stack<Integer> stack = new Stack<>();

        for (int i : graph.keySet()) {
            visited.put(i, false);
            vertices.add(i);
        }

        // this counter is so that we won't miss any nodes in case there are missing links.
        int counter = 0;
        int firstNum = vertices.get(counter);

        while (!stack.isEmpty() || !allVisited) {
            int nextNum;
            if (stack.isEmpty()) {
                counter += 1;
                // if stack is empty and there are no more vertices that means everything is visited.
                if (counter >= vertices.size()) {
                    break;
                }
                nextNum = vertices.get(counter);
            } else {
                nextNum = stack.pop();
            }

            if (target == nextNum) {
                System.out.println(true);
                return true;
            }

            // if the number is not visited, add to the stack;
            if (visited.get(nextNum) == false) {
                dfsTracker.add(nextNum);
                for (int adjToNextNum : graph.get(nextNum)) {
                    stack.add(adjToNextNum);
                }
                visited.put(nextNum, true);
            }

            // allVisited condition
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

    public static void topSort(Map<Integer, Set<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> vertices = new ArrayList<>();
        for (int v : graph.keySet()) {
            visited.put(v, false);
            vertices.add(v);
        }

        for (int v : vertices) {
            if (visited.get(v) == false) {
                topSortHelper(graph, v, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void topSortHelper(Map<Integer, Set<Integer>> graph, int v, Map<Integer, Boolean> visited, Stack<Integer> stack) {
        if (graph.get(v) == null || visited.get(v) == true) return;
        visited.put(v, true);

        for (int i : graph.get(v)) {
            topSortHelper(graph, i, visited, stack);
        }

        stack.push(v);
    }

    public static void main(String[] args) {
        /*
         int[][] edges = new int[5][2];
         edges[0] = new int[]{1,2};
         edges[1] = new int[]{2,3};
         edges[2] = new int[]{1,3};
         edges[3] = new int[]{3,2};
         edges[4] = new int[]{2,0};
        Map<Integer, Set<Integer>> graph = adjacencySet(edges);

        System.out.println("BFS");
        System.out.println();
        bfs(99, graph);
        System.out.println(bfsTracker);
        bfs(2, null);
        bfs(2, graph);
        bfs(0, graph);
        bfs(1, graph);
        bfs(3, graph);
        bfs(-88, graph);

        System.out.println();
        System.out.println("DFS");
        dfs(99, graph);
        System.out.println(dfsTracker);
        dfs(2, null);
        dfs(2, graph);
        dfs(0, graph);
        dfs(1, graph);
        dfs(3, graph);
        dfs(-88, graph);

        // another test with trinary tree
        int[][] anotheredges = new int[5][2];
        anotheredges[0] = new int[]{0,1};
        anotheredges[1] = new int[]{0,2};
        anotheredges[2] = new int[]{0,3};
        anotheredges[3] = new int[]{1,4};
        anotheredges[4] = new int[]{4,5};
        Map<Integer, Set<Integer>> anothergraph = adjacencySet(anotheredges);

        bfsTracker = new ArrayList<>();
        dfsTracker = new ArrayList<>();
        bfs(99, anothergraph);
        System.out.println(bfsTracker);
        dfs(99, anothergraph);
        System.out.println(dfsTracker);
        */

        int[][] topSortTest = new int[6][2];
        topSortTest[0] = new int[]{5,2};
        topSortTest[1] = new int[]{5,0};
        topSortTest[2] = new int[]{4,0};
        topSortTest[3] = new int[]{4,1};
        topSortTest[4] = new int[]{2,3};
        topSortTest[5] = new int[]{3,1};
        Map<Integer, Set<Integer>> tsGraph = adjacencySet(topSortTest);
        topSort(tsGraph);
    }
}