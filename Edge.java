public class Edge {
    private Node destination;
    private int weight;
    private String description;

    public Edge(Node destination, int weight, String description) {
        this.destination = destination;
        this.weight = weight;
        this.description = description;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}