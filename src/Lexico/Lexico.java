package Lexico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexico {
    public static void main(String[] args) throws FileNotFoundException {
        // String[] fileName = {"test", "testeSoma"};
        // BufferedReader br = new BufferedReader(new FileReader("src/testes/"+fileName[0]+".ura"));

        // runLexico(br);
    }

    public void runLexico(BufferedReader br){
        try {
            // Lê o arquivo de código-fonte
            String line;

            // Loop para ler cada linha do arquivo
            while ((line = br.readLine()) != null) {

                Pattern pattern = Pattern.compile("\\w+|[(),;{}]");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String token = matcher.group();

                    if (ehDelimitador(token)) {
                        System.out.println("Delimitador: " + token);
                    } else {
                        TokenType tokenType = palavras.get(token);
                        if (tokenType != null) {
                            System.out.println("Palavra reservada: " + token);
                        } else if (ehIdentificador(token)) {
                            if (!tabelaSimbolo.containsKey(token)) {

                                String dataType = perguntaTipo(token);
                                tabelaSimbolo.put(token, dataType);
                            }
                            System.out.println("Identificador: " + token + ", Tipo: " + tabelaSimbolo.get(token));
                        } else if (ehInteiroLiteral(token)) {
                            System.out.println("Literal Inteiro: " + token);
                        } else if (ehFloatLiteral(token)) {
                            System.out.println("Literal de Ponto Flutuante: " + token);
                        } else if (ehCharLiteral(token)) {
                            System.out.println("Literal de Caractere: " + token);
                        } else if (ehStringLiteral(token)) {
                            System.out.println("Literal de String: " + token);
                        } else if (ehOperador(token)) {
                            System.out.println("Operador: " + token);
                        } else {
                            System.out.println("Token Desconhecido: " + token);
                        }
                    }
                }
            }
            //br.close();
            System.out.println("\nTabela de Símbolos:");
            for (Map.Entry<String, String> entry : tabelaSimbolo.entrySet()) {
                System.out.println("Identificador: " + entry.getKey() + ", Tipo: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Definição de mapas para palavras reservadas e tabela de símbolos
    private static final Map<String, TokenType> palavras;
    private static final Map<String, String> tabelaSimbolo = new HashMap<>(); // Tabela de símbolos

    // Bloco estático para inicializar o mapa de palavras reservadas
    static {
        palavras = new HashMap<>();
        palavras.put("if", TokenType.IF);
        palavras.put("else", TokenType.ELSE);
        palavras.put("while", TokenType.WHILE);
        palavras.put("for", TokenType.FOR);
        palavras.put("int", TokenType.INT);
        palavras.put("float", TokenType.FLOAT);
        palavras.put("double", TokenType.DOUBLE);
        palavras.put("char", TokenType.CHAR);
        palavras.put("string", TokenType.STRING);
        palavras.put("true", TokenType.TRUE);
        palavras.put("false", TokenType.FALSE);
        palavras.put("return", TokenType.RETURN);
    }

    private static boolean ehDelimitador(String token) {
        return token.equals(",") || token.equals(";") || token.equals("{") || token.equals("}");
    }

    private static boolean ehIdentificador(String token) {
        return !palavras.containsKey(token);
    }

    private static boolean ehInteiroLiteral(String token) {
        return token.matches("\\d+");
    }

    private static boolean ehFloatLiteral(String token) {
        return token.matches("\\d+\\.\\d+");
    }

    private static boolean ehCharLiteral(String token) {
        return token.matches("'.'");
    }

    private static boolean ehStringLiteral(String token) {
        return token.matches("\".*\"");
    }

    private static boolean ehOperador(String token) {
        return token.matches("[+\\-*/]");
    }

    // Função para solicitar ao usuário o tipo de dado de um identificador
    private static String perguntaTipo(String identifier) {
        if (ehInteiroLiteral(identifier)) {
            return "int";
        } else if (ehFloatLiteral(identifier)) {
            return "float";
        } else if (ehCharLiteral(identifier)) {
            return "char";
        } else if (ehStringLiteral(identifier)) {
            return "string";
        } else if (identifier.equalsIgnoreCase("true") || identifier.equalsIgnoreCase("false")) {
            return "boolean";
        } else {
            return "indefinido";
        }
    }

    enum TokenType {
        IF,
        ELSE,
        WHILE,
        FOR,
        INT,
        FLOAT,
        DOUBLE,
        CHAR,
        STRING,
        TRUE,
        FALSE,
        RETURN,
        IDENTIFIER
    }
}