import java.util.*;

public class Q6RoadNetworks {
    /**
     * In some states, it is not possible to drive between any two towns because they are not connected to the same road network.
     * Given a list of towns and a list of pairs representing roads between towns, return the number of road networks.
     * (For example, a state in which all towns are connected by roads has 1 road network,
     * and a state in which none of the towns are connected by roads has 0 road networks.)
     *
     * Examples:
     * Input: ["Skagway", "Juneau", "Gustavus", "Homer", "Port Alsworth", "Glacier Bay", "Fairbanks", "McCarthy", "Copper Center", "Healy"],
     * [("Anchorage", "Homer"), ("Glacier Bay", "Gustavus"), ("Copper Center", "McCarthy"), ("Anchorage", "Copper Center"), ("Copper Center", "Fairbanks"), ("Healy", "Fairbanks"), ("Healy", "Anchorage")]
     *
     * Output: 2 (Networks are Gustavus-Glacier Bay and Anchorage-Fairbanks-McCarthy-Copper Center-Homer-Healy)
     *
     * Input: ["Kona", "Hilo", "Volcano", "Lahaina", "Hana", "Haiku", "Kahului", "Princeville", "Lihue", "Waimea"], [("Kona", "Volcano"), ("Volcano", "Hilo") ("Lahaina", "Hana"), ("Kahului", "Haiku"), ("Hana", "Haiku"), ("Kahului", Lahaina"), ("Princeville", "Lihue"), ("Lihue", "Waimea")]
     *
     * Output: 2 (Networks are Kona-Hilo-Volcano, Haiku-Kahului-Lahaina-Hana, and Lihue-Waimea-Princeville)
     */

    // algorithm: quick find using hashmap
    // time complexity: O(n) - for loops and hashmap worst case
    // space complexity: O(n) - hashmap uses up linear space

    // represent all of them in an array and solve it with a disjoint sets array
    // i guess this can be solved in the bfs way too?

    // time: getting to it took long but quick find itself was very fast

    public static int roadNetworks(String[] towns, String[][] routes) {

        // create an array of towns and assign each an id using a treeset, and represent those in the array
        Map<String, Integer> townId = new HashMap<>();
        int[] id = new int[towns.length];
        for (int i = 0; i < towns.length; i++) {
            townId.put(towns[i], i);
            id[i] = i;
        }


        for (int i = 0; i < routes.length; i++) {
            int townFrom = townId.get(routes[i][0]);
            int townTo = townId.get(routes[i][1]);
            connect(id, townFrom, townTo);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int ip : id) {
            if (!map.containsKey(ip)) {
                map.put(ip, 1);
            } else {
                map.put(ip, map.get(ip) + 1);
            }
            System.out.println(map);
        }

        int network = 0;
        for (int j : map.keySet()) {
            if (map.get(j) > 1) {
                network++;
            }
        }

        return network;
    }

    public static void connect(int[] id, int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }
    public static void main(String[] args) {
        String[] towns = {"Anchorage", "Skagway", "Juneau", "Gustavus", "Homer", "Port Alsworth", "Glacier Bay", "Fairbanks", "McCarthy", "Copper Center", "Healy"};
        String[][] routes = {{"Anchorage", "Homer"}, {"Glacier Bay", "Gustavus"}, {"Copper Center", "McCarthy"}, {"Anchorage", "Copper Center"}, {"Copper Center", "Fairbanks"}, {"Healy", "Fairbanks"}, {"Healy", "Anchorage"}};
        System.out.println(roadNetworks(towns, routes));

        String[] town = {"ygn", "mdy", "pth", "htd"};
        String[][] route = {{"ygn","mdy"},{"pth", "htd"}};
        String[][] route2 = {{"ygn","mdy"},{"htd", "ygn"},{"mdy","pth"}};
        String[][] route3 = {{"ygn","mdy"},{"pth", "htd"}};
        //System.out.println(roadNetworks(town, route));
        //System.out.println(roadNetworks(town, route2));
    }
}
