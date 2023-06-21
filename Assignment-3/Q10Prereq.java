import java.util.*;

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


    public static List<String> topSort(List<String> courses, Map<String, String> prereqMapping) {
        List<String> validOrder = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (String c : courses) {
            visited.put(c, false);
            stack.push(c);
        }
        String earliest = null;
        for (String key : prereqMapping.keySet()) {
            String result = key;
            while (prereqMapping.containsKey(prereqMapping.get(result))) {
                result = prereqMapping.get(result);
            }
            earliest = prereqMapping.get(result);
            System.out.println(earliest);
        }

        // topological sort
        for (int i = 0; i < courses.size(); i++) {
            String currCourse = courses.get(i);
            if (visited.get(currCourse) == false) {

            }
        }

        return validOrder;
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
        Map<String, String> prereqMapping = new HashMap<>();
        prereqMapping.put("Data Structures", "Intro to Programming");
        prereqMapping.put("Advanced Algorithms", "Data Structures");
        prereqMapping.put("Operating Systems", "Advanced Algorithms");
        prereqMapping.put("Databases", "Advanced Algorithms");

        System.out.println(topSort(courses, prereqMapping));
    }
}
