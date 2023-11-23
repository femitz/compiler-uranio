package src.Sintatico;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sintatico {
    public static void main(String[] args) {
        // System.out.println("\n\n");
        // List<String> tokens = new ArrayList<>();

        // String scan = "1+2+3-4/5*6+(4+5)";
        // for (int i = 0; i < scan.length(); i++){
        //     char c = scan.charAt(i);
        //     tokens.add(Character.toString(c));
        // }
        

        // AnalisadorSintatico analisador = new AnalisadorSintatico(tokens);
        // analisador.analisar();
        AnalisadorVariavel variavel = new AnalisadorVariavel();
        //variavel.varAnalise("int x = 0 ;");
        validVariables("int x=0;");
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

    public static void validVariables(String entrada ){
        
        // se posição 0 for um toke ta certo
        // posição 1 n importa pode ser qualquer coisas mas pode ser feito um padrão em regex
        // posição 2 é exclusiva do = 
        // posição 3 deve ser o valor sendo str tem sua regra (no caso se for dividir com split da pra fazer um for até juntar tudo)
        // posição final tem q ser um ;
        

        if (entrada.contains("=")) {
            String[] token = entrada.split("="); // dividir toda palavra
            String[] parte1 = token[0].split(" ");

            switch (parte1[0]) {
                case "int": 
                    System.out.println("typagem ok");
                    if (token[1].matches("^[0-9\\+\\-\\*\\/\\.\\s]*;$")) {
                        System.out.println("expression ok");
                    } else {
                        System.out.println("expression not ok");
                    }
                    break;
                case "string":
                    System.out.println("typagem ok");
                    break;
                default:
                    System.out.println("typagem errada");
                    break;
            }
        } else {
            System.out.println("não é variavel");            
        }
    }
}
