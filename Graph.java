import java.util.*;

class Graph {
    private Map<String, List<String>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(String u, String v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public List<String> dfs(String start, String goal) {
        List<String> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        if (dfsHelper(start, goal, path, visited)) {
            return path;
        }
        return null;
    }

    private boolean dfsHelper(String current, String goal, List<String> path, Set<String> visited) {
        path.add(current);
        visited.add(current);

        if (current.equals(goal)) {
            return true;
        }

        for (String neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfsHelper(neighbor, goal, path, visited)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "D");
        g.addEdge("D", "E");

        String startBuilding = "A";
        String endBuilding = "E";
        List<String> path = g.dfs(startBuilding, endBuilding);

        if (path != null) {
            System.out.println("Path from " + startBuilding + " to " + endBuilding + ": " + String.join(" -> ", path));
        } else {
            System.out.println("No path found from " + startBuilding + " to " + endBuilding);
        }
    }
}
