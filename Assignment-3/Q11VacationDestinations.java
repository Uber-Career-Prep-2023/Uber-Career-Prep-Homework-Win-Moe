import java.util.*;

public class Q11VacationDestinations {
    public static class Edge {
        public String origin;
        public String destination;
        public double distance;
        public Edge(String origin, String destination, double distance) {
            this.origin = origin;
            this.destination = destination;
            this.distance = distance;
        }
    }

    public static int vacDest(List<Edge> edgeList, String origin, double k) {
        int count = 0;
        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> distances = new HashMap<>();
        for (Edge e : edgeList) {
            visited.put(e.origin, false);
            visited.put(e.destination, false);
            distances.put(e.origin, 0.0);
            distances.put(e.destination, 0.0);
        }

        distances.put(origin, 0.0);
        visited.put(origin, true);
        queue.add(origin);

        while (!queue.isEmpty()) {
            String toVisit = queue.poll();
            System.out.println(toVisit);

            for (Edge e : edgeList) {
                if (toVisit.equals(e.origin) && visited.get(e.destination) == false && (distances.get(e.destination) - e.distance) > 0) {
                    queue.offer(e.destination);
                    distances.put(e.destination, (distances.get(e.destination) - e.distance - 1));
                    System.out.println(distances);
                    visited.put(e.destination, true);
                    count += 1;
                }
                if (toVisit.equals(e.destination) && visited.get(e.origin) == false && (distances.get(e.origin) - e.distance) > 0) {
                    queue.offer(e.origin);
                    distances.put(e.origin, (distances.get(e.origin)) - e.distance - 1);
                    System.out.println(distances);
                    visited.put(e.origin, true);
                    count += 1;
                }
            }
        }

        return count;
    }

    // use bfs
    public static void main(String[] args) {
        Edge t = new Edge("Boston", "New York", 4);
        List<Edge> edgeList = Arrays.asList(t);

        //System.out.println(vacDest(edgeList, "Boston", 5));
        //System.out.println(vacDest(edgeList, "Boston", 2));


        Edge t2 = new Edge("Boston", "New York", 4);
        Edge t3 = new Edge("New York", "Philadelphia", 2);
        Edge t4 = new Edge("Boston", "Newport", 1.5);
        Edge t5 = new Edge("Washington, D.C.", "Harper's Ferry", 1);
        Edge t6 = new Edge("Boston", "Portland", 2.5);
        Edge t7 = new Edge("Philadelphia", "Washington, D.C.", 2.5);

        List<Edge> eList = Arrays.asList(t2, t3, t4, t5, t6, t7);
        System.out.println(vacDest(eList, "New York", 5));
        System.out.println(vacDest(eList, "New York", 7));
        System.out.println(vacDest(eList, "New York", 8));

    }
}
