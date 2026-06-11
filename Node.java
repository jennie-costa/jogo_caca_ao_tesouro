import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private boolean blocked;

    // Parte do "jogo"
    private String clue;   // pista
    private char letter;   // letra coletada
    private NodeType type; // NORMAL, DEAD, FINAL

    private List<Edge> edges;

    public Node(String name) {
        this.name = name;
        this.blocked = false;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }
}