import java.util.*;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();
    private Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
        adjacencyList.put(node.getName(), new ArrayList<>());
    }

    public void connect(String from, String to, int weight, String description) {
        Node origem = nodes.get(from);
        Node destino = nodes.get(to);

        if (origem != null && destino != null) {
            adjacencyList.get(from).add(new Edge(destino, weight, description));
        } else {
            System.out.println("Erro: nó não encontrado (" + from + " -> " + to + ")");
        }
    }

    public List<Edge> getEdges(String nodeName) {
        return adjacencyList.getOrDefault(nodeName, new ArrayList<>());
    }
}