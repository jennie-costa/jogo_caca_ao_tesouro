import java.util.ArrayList;
import java.util.List;

public class PlayerState {

    private Node currentNode;
    private List<Character> collectedLetters;
    private boolean alive;

    public PlayerState(Node start) {
        this.currentNode = start;
        this.collectedLetters = new ArrayList<>();
        this.alive = true;
    }

    public void moveTo(Node node) {
        this.currentNode = node;

        // coleta letra automaticamente
        if (node.getLetter() != '\0') {
            collectedLetters.add(node.getLetter());
        }

        // verifica morte
        if (node.getType() == NodeType.DEAD) {
            alive = false;
        }
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getWordFormed() {
        StringBuilder sb = new StringBuilder();
        for (char c : collectedLetters) {
            sb.append(c);
        }
        return sb.toString();
    }
}