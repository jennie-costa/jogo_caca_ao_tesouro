import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Criando nós
        Node inicio = new Node("Inicio");
        Node cabana = new Node("Cabana");
        Node lago = new Node("Lago");
        Node caverna = new Node("Caverna");
        Node farol = new Node("Farol");
        Node tesouro = new Node("Tesouro");
        Node morte = new Node("Morte");

        // Configurando tipos
        inicio.setType(NodeType.NORMAL);
        cabana.setType(NodeType.NORMAL);
        lago.setType(NodeType.NORMAL);
        caverna.setType(NodeType.NORMAL);
        farol.setType(NodeType.NORMAL);
        tesouro.setType(NodeType.FINAL); 
        morte.setType(NodeType.DEAD);

        // Pistas e letras
        cabana.setClue("Talvez haja algo interessante te aguardando no lago. Atravessar a ponte é mais seguro!");
        cabana.setLetter('C');

        lago.setClue("No fim, todos não passarão de ossos. Encontre a caveira, mas tome cuidado!");
        lago.setLetter('A');

        caverna.setClue("A escuridão pode esconder segredos, mas a luz revela o caminho.");
        caverna.setLetter('S');

        farol.setClue("Olha só, o que é aquilo brilhando? Você encontrou o tesouro!");
        farol.setLetter('A');

        morte.setClue("Você caiu em uma armadilha! Fim de jogo.");

        // Adicionando nós
        graph.addNode(inicio);
        graph.addNode(cabana);
        graph.addNode(lago);
        graph.addNode(caverna);
        graph.addNode(farol);
        graph.addNode(tesouro);
        graph.addNode(morte);

        // Conexões
        graph.connect("Inicio", "Cabana", 1, "Vá para a cabana");
        graph.connect("Cabana", "Lago", 1, "Atravessar a ponte para o lago");
        graph.connect("Lago", "Caverna", 1, "Siga o rio até a caverna");
        graph.connect("Caverna", "Farol", 1, "Ir para o farol");
        graph.connect("Farol", "Tesouro", 1, "Ir para o tesouro");

        // Caminhos de morte
        graph.connect("Inicio", "Morte", 1, "Entrar na floresta escura");
        graph.connect("Cabana", "Morte", 1, "Pular no rio");
        graph.connect("Lago", "Morte", 1, "Ir para o navio abandonado");
        graph.connect("Caverna", "Morte", 1, "Ir para o castelo");

        // Jogo
        Scanner scanner = new Scanner(System.in);
        Node atual = inicio;
        StringBuilder palavra = new StringBuilder();
        StringBuilder caminho = new StringBuilder(atual.getName());

        System.out.println("Seja Bem-vindo ao Caça ao Tesouro!");

        while (true) {
        System.out.println("\nVocê está em: " + atual.getName());
        System.out.println("Caminho percorrido: " + caminho);

        if (atual.getType() == NodeType.DEAD) {
            System.out.println("!GAME OVER!");
            break;
        }

        if (atual.getClue() != null) {
            System.out.println("Dica: " + atual.getClue());
        }

        if (atual.getLetter() != '\0') {
            palavra.append(atual.getLetter());
            System.out.println("Letra encontrada: " + atual.getLetter());
        }

        if (atual.getType() == NodeType.FINAL) {
            System.out.println("\nVocê chegou ao tesouro!");

            System.out.println("Digite a palavra formada durante a jornada: ");
            System.out.println("Dica: a palavra possui " + palavra.length() + " letras.");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase(palavra.toString())) {
                System.out.println("Parabéns! Você encontrou o tesouro!");
                System.out.println("Palavra correta: " + palavra);
            } else {
                System.out.println("Palavra incorreta! O tesouro escapou!");
                System.out.println("A palavra correta era: " + palavra);
            }

            break;
        }

        List<Edge> opcoes = graph.getEdges(atual.getName());
        System.out.println("\nEscolha um caminho:");
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println("[" + i + "] " + opcoes.get(i).getDescription());
        }

        int escolha;
        
        while (true) {
            System.out.print("Digite sua escolha: ");
            escolha = scanner.nextInt();
            if (escolha >= 0 && escolha < opcoes.size()) {
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        atual = opcoes.get(escolha).getDestination();
        caminho.append(" -> ").append(atual.getName());
    }
        scanner.close();
    }
}