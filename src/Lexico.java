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

                    if (isDelimiter(token)) {
                        System.out.println("Delimitador: " + token);
                    } else {
                        TokenType tokenType = keywords.get(token);
                        if (tokenType != null) {
                            System.out.println("Palavra reservada: " + token);
                        } else if (isIdentifier(token)) {
                            if (!symbolTable.containsKey(token)) {

                                String dataType = askForDataType(token);
                                symbolTable.put(token, dataType);
                            }
                            System.out.println("Identificador: " + token + ", Tipo: " + symbolTable.get(token));
                        } else if (isIntegerLiteral(token)) {
                            System.out.println("Literal Inteiro: " + token);
                        } else if (isFloatLiteral(token)) {
                            System.out.println("Literal de Ponto Flutuante: " + token);
                        } else if (isCharLiteral(token)) {
                            System.out.println("Literal de Caractere: " + token);
                        } else if (isStringLiteral(token)) {
                            System.out.println("Literal de String: " + token);
                        } else if (isOperator(token)) {
                            System.out.println("Operador: " + token);
                        } else {
                            System.out.println("Token Desconhecido: " + token);
                        }
                    }
                }
            }
            //br.close();
            System.out.println("\nTabela de Símbolos:");
            for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
                System.out.println("Identificador: " + entry.getKey() + ", Tipo: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Definição de mapas para palavras reservadas e tabela de símbolos
    private static final Map<String, TokenType> keywords;
    private static final Map<String, String> symbolTable = new HashMap<>(); // Tabela de símbolos

    // Bloco estático para inicializar o mapa de palavras reservadas
    static {
        keywords = new HashMap<>();
        keywords.put("if", TokenType.IF);
        keywords.put("else", TokenType.ELSE);
        keywords.put("while", TokenType.WHILE);
        keywords.put("for", TokenType.FOR);
        keywords.put("int", TokenType.INT);
        keywords.put("float", TokenType.FLOAT);
        keywords.put("double", TokenType.DOUBLE);
        keywords.put("char", TokenType.CHAR);
        keywords.put("string", TokenType.STRING);
        keywords.put("true", TokenType.TRUE);
        keywords.put("false", TokenType.FALSE);
        keywords.put("return", TokenType.RETURN);
    }

    private static boolean isDelimiter(String token) {
        return token.equals(",") || token.equals(";") || token.equals("{") || token.equals("}");
    }

    private static boolean isIdentifier(String token) {
        return !keywords.containsKey(token);
    }

    private static boolean isIntegerLiteral(String token) {
        return token.matches("\\d+");
    }

    private static boolean isFloatLiteral(String token) {
        return token.matches("\\d+\\.\\d+");
    }

    private static boolean isCharLiteral(String token) {
        return token.matches("'.'");
    }

    private static boolean isStringLiteral(String token) {
        return token.matches("\".*\"");
    }

    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    // Função para solicitar ao usuário o tipo de dado de um identificador
    private static String askForDataType(String identifier) {
        if (isIntegerLiteral(identifier)) {
            return "int";
        } else if (isFloatLiteral(identifier)) {
            return "float";
        } else if (isCharLiteral(identifier)) {
            return "char";
        } else if (isStringLiteral(identifier)) {
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