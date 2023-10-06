// linguagem de programação uranio

import Lexico.Lexico;
import Sintatico.Sintatico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    System.out.println("\n\n");

    String[] nomeArquivo = {"test", "testeSoma"};

    runTeste(nomeArquivo[0]);

    // for (int i = 0; i < fileName.length; i++) {
    //   runTeste(fileName[i]);
    //   System.out.println("\n------------------------------------------------------------\n");
    // }
    
  }
  
  public static void runTeste(String file) throws IOException{
    Lexico lexico = new Lexico();
    Sintatico sintatico = new Sintatico();

    BufferedReader br = new BufferedReader(new FileReader("src/testes/"+file+".ura"));
    System.out.println(file+".ura\n");
      
    System.out.println("\nLexico:\n");
    lexico.runLexico(br); // aqui em algummomento joga fora o arquivo por isso o br2
    
    BufferedReader br2 = new BufferedReader(new FileReader("src/testes/"+file+".ura"));
    System.out.println("\nSintatico:\n");
    while ((br2.readLine()) != null){
      sintatico.runSintatico(br2.readLine());
    }
    br2.close();
  }
}
