// linguagem de programação uranio

import Lexico.Lexico;
import Sintatico.Sintatico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    System.out.println("\n\n");

    // nomes dos arquivos
    String[] testInicialArquivo = {"test", "testeSoma"};
    //String[] testSintaxErrArquivo = {};

    // separadores de arquivos por categoria
    class test{
      public String testInicial(int index){
        String res = "test/"+testInicialArquivo[index]+".ura";
        return res;
      }
      
      // public String testSintaxErr(int index){
      //   String res = "test/"+testSintaxErrArquivo[index]+".ura";
      //   return res;
      // }
    }


    // teste final

    test test = new test();

    runTeste(test.testInicial(0));    

  }
  
  public static void runTeste(String file) throws IOException{
    Lexico lexico = new Lexico();
    Sintatico sintatico = new Sintatico();
    System.out.println(file);

    BufferedReader br = new BufferedReader(new FileReader(file));

    System.out.println("\nCodigo:\n");
    int i = 0;
    while ((br.readLine()) != null){
      System.out.println((i++) +"\t"+ br.readLine());
    }
    br.close();
    
    BufferedReader br1 = new BufferedReader(new FileReader(file));
    System.out.println("\nLexico:\n");
    lexico.runLexico(br1); // aqui em algummomento joga fora o arquivo por isso o br2
    
    BufferedReader br2 = new BufferedReader(new FileReader(file));
    System.out.println("\nSintatico:\n");
    while ((br2.readLine()) != null){
      sintatico.runSintatico(br2.readLine());
    }
    br2.close();

    System.out.println("\n------------------------------------------------------------\n");
  }
}
