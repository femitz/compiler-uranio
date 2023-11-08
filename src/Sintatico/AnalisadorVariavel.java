package src.Sintatico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AnalisadorVariavel {
    public static void varAnalise(String i) {
        String entrada = i;
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

        String padraoCodigo = "^((if\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "(for\\s*\\(([^;]+);([^;]+);([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "(while\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\})|"
                + "(do\\s*\\{([^}]*)\\}\\s*while\\s*\\(([^)]+)\\);)|"
                + "(switch\\s*\\(([^)]+)\\)\\s*\\{([^}]*)\\}))$|"
                + "(case\\s*(\\d+)\\s*:\\s*(.+?)\\s*break;)|"
                + "(default\\s*:\\s*(.+?)\\s*break;)$";

        Pattern patternCodigo = Pattern.compile(padraoCodigo, Pattern.MULTILINE);
        Matcher matcherCodigo = patternCodigo.matcher(entradaCodigo);

        boolean dentroDoLoop = false;
        boolean dentroDoSwitch = false;

        while (matcherCodigo.find()) {
            if (matcherCodigo.group(1) != null) {
                dentroDoLoop = false;
                dentroDoSwitch = true;
            } else if (matcherCodigo.group(4) != null || matcherCodigo.group(9) != null
                    || matcherCodigo.group(12) != null) {
                dentroDoLoop = true;
                dentroDoSwitch = false;
            } else if (matcherCodigo.group(21) != null) {
                dentroDoLoop = false;
                dentroDoSwitch = false;
            } else if (matcherCodigo.group(22) != null) {
                if (dentroDoLoop) {
                    if (dentroDoSwitch && matcherCodigo.group(22).contains("break;")) {
                        System.out.println("Instrução 'break' encontrada dentro do bloco switch.");
                    } else if (matcherCodigo.group(22).contains("break;")) {
                        System.out.println("Instrução 'break' encontrada fora de um bloco switch.");
                    }
                }
            }
        }
    }
}
