import java.util.ArrayList;
import java.util.List;

class AnalisadorSintatico {
    private List<String> tokens = new ArrayList<>();
    
    // tokens.add("2");
    // tokens.add("+");
    // tokens.add("3");
    // tokens.add("*");
    // tokens.add("(");
    // tokens.add("4");
    // tokens.add("+");
    // tokens.add("5");
    // tokens.add(")");
    private int indice;

    public AnalisadorSintatico(List<String> tokens) {
        this.tokens = tokens;
        this.indice = 0;
    }

    public void analisar() {
        expressao();
        if (indice == tokens.size()) {
            System.out.println("Análise sintática bem-sucedida.\n"+ indice + " / " + tokens);
        } else {
            System.out.println("Erro de análise sintática.");
        }
    }

    private void expressao() {
        termo();
        while (indice < tokens.size() && (tokens.get(indice).equals("+") || tokens.get(indice).equals("-"))) {
            indice++;
            termo();
        }
    }

    private void termo() {
        fator();
        while (indice < tokens.size() && (tokens.get(indice).equals("*") || tokens.get(indice).equals("/"))) {
            indice++;
            fator();
        }
    }

    private void fator() {
        if (indice < tokens.size()) {
            String token = tokens.get(indice);
            if (token.matches("\\d+")) {
                indice++;
            } else if (token.equals("(")) {
                indice++;
                expressao();
                if (indice < tokens.size() && tokens.get(indice).equals(")")) {
                    indice++;
                } else {
                    System.out.println("Erro: Esperado ')'");
                }
            } else {
                System.out.println("Erro: Esperado número ou '('");
            }
        }
    }
}

public class Sintatico {
    public static void main(String[] args) {
        System.out.println("\n\n");
        List<String> tokens = new ArrayList<>();
        // Preencha a lista de tokens com os tokens da sua entrada
        // Exemplo: tokens.add("2"); tokens.add("+"); tokens.add("3"); ...

        // tokens.add("2");
        // tokens.add("+");
        // tokens.add("3");
        // tokens.add("*");
        // tokens.add("(");
        // tokens.add("4");
        // tokens.add("+");
        // tokens.add("5");
        // tokens.add(")");

        String scan = "int x =  30;";
        for (int i = 0; i < scan.length(); i++){
            char c = scan.charAt(i);
            tokens.add(Character.toString(c));
        }
        

        AnalisadorSintatico analisador = new AnalisadorSintatico(tokens);
        analisador.analisar();
    }

    public void runSintatico(String line){
        List<String> tokens = new ArrayList<>();
        String scan = line;
        for (int i = 0; i < scan.length(); i++){
            char c = scan.charAt(i);
            tokens.add(Character.toString(c));
        }

        AnalisadorSintatico analisador = new AnalisadorSintatico(tokens);
        analisador.analisar();
    }

}
