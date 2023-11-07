package Sintatico;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

class AnalisadorVariavel{
    public static void varAnalise(String i){
        String entrada = "nome \"Exemplo\" = true;";

        String padrao = "^(\\w+)\\s+\"([^\"]*)\"\\s*=\\s*(true|false|\\d+(?:\\.\\d+)?)\\s*;$";

        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(entrada);

        if (matcher.matches()) {
            String tipo = matcher.group(1);
            String valor = matcher.group(2);
            String atributo = matcher.group(3);

            if (tipo.equals("nome") && valor.startsWith("\"") && valor.endsWith("\"")) {
                System.out.println("Tipo: String");
                System.out.println("Valor: " + valor);
                System.out.println("Atributo: " + atributo);
            } else if (tipo.equals("nome") && (valor.equals("true") || valor.equals("false"))) {
                System.out.println("Tipo: Boolean");
                System.out.println("Valor: " + valor);
                System.out.println("Atributo: " + atributo);
            } else if (tipo.equals("nome") && valor.matches("\\d+(\\.\\d+)?")) {
                if (valor.contains(".")) {
                    System.out.println("Tipo: Double");
                    System.out.println("Valor: " + valor);
                } else {
                    System.out.println("Tipo: Integer");
                    System.out.println("Valor: " + valor);
                }
                System.out.println("Atributo: " + atributo);
            } else {
                System.out.println("Tipo: Desconhecido");
                System.out.println("Valor: " + valor);
                System.out.println("Atributo: " + atributo);
            }

        } else {
            System.out.println("Entrada inválida.");
        }

        String entradaCodigo = "if (x > 10) { nome \"Exemplo\" = true; } else if (x < 5) { nome \"Outro\" = false; } else { nome \"Nenhum\" = 42; } "
                + "for (int i = 0; i < 10; i++) { nome \"LoopFor\" = i; } "
                + "while (x > 0) { nome \"LoopWhile\" = x; x--; } "
                + "do { nome \"LoopDoWhile\" = x; x--; } while (x > 0); "
                + "switch (x) { "
                + "case 1: nome \"Caso1\" = true; break; "
                + "case 2: nome \"Caso2\" = false; break; "
                + "default: nome \"Padrao\" = 42; }";

        String padraoCodigo = "^(if\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "^(for\\s*\\(([^;]+);([^;]+);([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "^(while\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "^(do\\s*\\{([^}]*)\\}\\s*while\\s*\\(([^)]+)\\);)|"
                + "^(switch\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\})$|"
                + "^(case\\s*(\\d+)\\s*:\\s*(.+?)\\s*break;)|"
                + "^(default\\s*:\\s*(.+?)\\s*break;)$";

        Pattern patternCodigo = Pattern.compile(padraoCodigo, Pattern.MULTILINE);
        Matcher matcherCodigo = patternCodigo.matcher(entradaCodigo);

        boolean dentroDoLoop = false;

        while (matcherCodigo.find()) {
            if (matcherCodigo.group(1) != null) {

            } else if (matcherCodigo.group(4) != null) {
                dentroDoLoop = true;

            } else if (matcherCodigo.group(9) != null) {
                dentroDoLoop = true;

            } else if (matcherCodigo.group(12) != null) {
                dentroDoLoop = true;

            } else if (matcherCodigo.group(21) != null) {
                if (dentroDoLoop && matcherCodigo.group(22) != null && matcherCodigo.group(22).contains("break")) {
                    System.out.println("Instrução 'break' encontrada.");
                }

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

        String scan = "1+2+3-4/5*6+(4+5)";
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
