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

    String[] testSintaxErrArquivo = {"teste de erroprint","teste de erroprint","teste expo"};

    String[] testSintaxCorrectArquivo = {"teste dowhile","teste for_2","teste for","teste if","teste while"};

    // separadores de arquivos por categoria
    class test{
      public String testInicial(int index){
        return "test/"+testInicialArquivo[index]+".ura";
      }
      
      public String testSintaxErr(int index){
        return "test/err/"+testSintaxErrArquivo[index]+".ura";
      }

      public String testSintaxCorrect(int index){
        return "test/acert/"+testSintaxCorrectArquivo[index]+".ura";
      }
    }

    // teste final

    test test = new test();

    runTeste(test.testInicial(0));    


    // for (int i = 0; i < testInicialArquivo.length; i++) runTeste(test.testInicial(i));
    // for (int i = 0; i < testSintaxCorrectArquivo.length; i++) runTeste(test.testSintaxCorrect(i));
    // for (int i = 0; i < testSintaxErrArquivo.length; i++) runTeste(test.testSintaxErr(i));

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
    br1.close();
    
    BufferedReader br2 = new BufferedReader(new FileReader(file));
    System.out.println("\nSintatico:\n");
    while ((br2.readLine()) != null){
      sintatico.runSintatico(br2.readLine());
    }
    br2.close();

    System.out.println("\n------------------------------------------------------------\n");
  }
}
