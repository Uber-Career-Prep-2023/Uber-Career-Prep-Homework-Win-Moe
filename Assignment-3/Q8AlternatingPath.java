// Queue, Adjacency List, BFS
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
// worst case is all vertices and edges need to be visited
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Q8AlternatingPath {
    Map<String, ArrayList<Edge>> aL;
    String origin;
    String destination;

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge("A", "B", "blue"));
        edges.add(new Edge("A", "C", "red"));
        edges.add(new Edge("B", "D", "blue"));
        edges.add(new Edge("B", "E", "blue"));
        edges.add(new Edge("C", "B", "red"));
        edges.add(new Edge("D", "C", "blue"));
        edges.add(new Edge("A", "D", "red"));
        edges.add(new Edge("D", "E", "red"));
        edges.add(new Edge("E", "C", "red"));

        Q8AlternatingPath a = new Q8AlternatingPath(edges, "A", "E");
        System.out.println(a.findAlternatingPath());
        Q8AlternatingPath b = new Q8AlternatingPath(edges, "E", "D");
        System.out.println(b.findAlternatingPath());

    }

    // composes the "edges" ArrayList
    public static class Edge {
        private final String origin;
        private final String destination;
        private final String color;
        public Edge(String origin, String destination, String color) {
            this.origin = origin;
            this.destination = destination;
            this.color = color;
        }
        public String getOrigin() {
            return this.origin;
        }
        public String getDestination() {
            return this.destination;
        }
        public String getColor() {
            return this.color;
        }
    }

    // composes the queue
    public static class Node {
        private final String node;
        private final String prevColor;
        private final int pathLength;

        public Node(String node, String prevColor, int pathLength) {
            this.node = node;
            this.prevColor = prevColor;
            this.pathLength = pathLength;
        }

        public String getNodeLetter() {
            return node;
        }
        public String getPrevColor() {
            return prevColor;
        }
        public int getPathLength() {
            return pathLength;
        }
    }

    public Q8AlternatingPath(ArrayList<Edge> edges, String origin, String destination) {
        // create adjacency list holding each Node's edges
        this.aL = new HashMap<>();
        this.origin = origin;
        this.destination = destination;

        for (Edge e : edges) {
            String o = e.getOrigin();
            if (!aL.containsKey(o)) {
                aL.put(o, new ArrayList<>());
            }
            aL.get(o).add(e);
        }
    }

    public int findAlternatingPath() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(origin, null, 0));

        // insert Nodes with nodeLetter, color, and pathLength into queue
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String currNode = node.getNodeLetter();
            String prevColor = node.getPrevColor();
            int pathLength = node.getPathLength();

            // if the node is the destination, return the pathLength
            if (currNode.equals(destination)) {
                return pathLength;
            }
            ArrayList<Edge> neighbors = aL.getOrDefault(currNode, new ArrayList<>());
            for (Edge neighbor : neighbors) {
                String color = neighbor.getColor();
                // ensure that the next Node preserves alternating color attribute
                if (!color.equals(prevColor)) {
                    queue.offer(new Node(neighbor.getDestination(), color, pathLength + 1));
                }
            }
        }
        // destination not reached
        return -1;

    }
}

