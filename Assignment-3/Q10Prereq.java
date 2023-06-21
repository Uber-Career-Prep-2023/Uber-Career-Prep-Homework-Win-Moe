import java.util.*;

// topological sorting using stacks, modified dfs
// time complexity: O(V+E)
public class Q10Prereq {
    /**
     * Input: ["Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases"],
     * { "Data Structures": ["Intro to Programming"],
     * "Advanced Algorithms": ["Data Structures"],
     * "Operating Systems": ["Advanced Algorithms"],
     * "Databases": ["Advanced Algorithms"] }
     *
     * Output: ["Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases"] or
     * ["Intro to Programming", "Data Structures", "Advanced Algorithms", "Databases", "Operating Systems"]
     */

    // turn it into a graph and use topSort
    public static Map<String, Set<String>> adjacencySet(List<String> courses, Map<String, List<String>> prereqMapping) {
        if (prereqMapping == null) {
            return null;
        }

        Map<String, Set<String>> adjSet = new HashMap<>();
        for (String key : courses) {
            adjSet.put(key, new HashSet<>());
        }

        for (String key : prereqMapping.keySet()) {
            for (String source : prereqMapping.get(key)) {
                String target = key;
                Set<String> setToAdd = adjSet.get(source);
                setToAdd.add(target);
            }
        }

        //test
        System.out.println(adjSet);

        return adjSet;
    }

    public static List<String> topSort(List<String> courses, Map<String, List<String>> prereqMapping) {
        List<String> validOrder = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Map<String, Set<String>> adjSet = adjacencySet(courses, prereqMapping);

        // topological sort
        for (String s : courses) {
            visited.put(s, false);
        }

        for (int i = 0; i < courses.size(); i++) {
            String currCourse = courses.get(i);
            if (visited.get(currCourse) == false) {
                topSortHelper(adjSet, currCourse, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            String curr = stack.pop();
            System.out.println(curr);
            validOrder.add(curr);
        }

        return validOrder;
    }

    public static void topSortHelper(Map<String, Set<String>> graph, String v, Map<String, Boolean> visited, Stack<String> stack) {
        if (graph.get(v) == null || visited.get(v) == true) return;
        visited.put(v, true);

        for (String i : graph.get(v)) {
            topSortHelper(graph, i, visited, stack);
        }

        stack.push(v);
    }

    /*
    Approach:

Create a stack to store the nodes.
Initialize visited array of size N to keep the record of visited nodes.
Run a loop from 0 till N
if the node is not marked True in visited array
Call the recursive function for topological sort and perform the following steps.
Mark the current node as True in the visited array.
Run a loop on all the nodes which has a directed edge to the current node
if the node is not marked True in the visited array:
Recursively call the topological sort function on the node
Push the current node in the stack.
Print all the elements in the stack.

     */

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Intro to Programming", "Data Structures", "Advanced Algorithms", "Operating Systems", "Databases");
        Map<String, List<String>> prereqMapping = new HashMap<>();
        prereqMapping.put("Data Structures", Arrays.asList("Intro to Programming"));
        prereqMapping.put("Advanced Algorithms", Arrays.asList("Data Structures"));
        prereqMapping.put("Operating Systems", Arrays.asList("Advanced Algorithms"));
        prereqMapping.put("Databases", Arrays.asList("Advanced Algorithms"));

        System.out.println(topSort(courses, prereqMapping));

        List<String> c2 = Arrays.asList("Intro to Writing", "Contemporary Literature", "Ancient Literature", "Comparative Literature", "Plays & Screenplays");
        Map<String, List<String>> p2 = new HashMap<>();
        p2.put("Contemporary Literature", Arrays.asList("Intro to Writing"));
        p2.put("Ancient Literature", Arrays.asList("Intro to Writing"));
        p2.put("Comparative Literature", Arrays.asList("Ancient Literature", "Contemporary Literature"));
        p2.put("Plays & Screenplays", Arrays.asList("Intro to Writing"));

        System.out.println(topSort(c2, p2));
    }
}
