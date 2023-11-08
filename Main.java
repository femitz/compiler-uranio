// linguagem de programação uranio

import src.Lexico.*;
import src.Sintatico.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    System.out.println("\n\n");

    runTeste(testeInicial(0));


    // for (int i = 0; i < testInicialArquivo.length; i++) runTeste(test.testInicial(i));
    // for (int i = 0; i < testSintaxCorrectArquivo.length; i++) runTeste(test.testSintaxCorrect(i));
    // for (int i = 0; i < testSintaxErrArquivo.length; i++) runTeste(test.testSintaxErr(i));

  }

  public static String testeInicial(int i) {
    String[] testInicialArquivo = {"test", "testeSoma"};
    return "test/"+testInicialArquivo[i]+".ura";
  }

  public static String testeSintaxErr(int i) {
    String[] testSintaxErrArquivo = {"teste de erroprint","teste de erroprint","teste expo"};
    return "test/err/"+testSintaxErrArquivo[i]+".ura";
  }

  public static String testeSintaxCorreto(int i){
    String[] testSintaxCorrectArquivo = {"teste dowhile","teste for_2","teste for","teste if","teste while"};
    return "test/acert/"+testSintaxCorrectArquivo[i]+".ura";
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
