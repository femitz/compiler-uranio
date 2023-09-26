// linguagem de programação uranio

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, IOException{
    System.out.println("\n\n");
    /// chamar os arquivos e fazer os respectivos testes de lexicos e sintaticos
    /// um arquvo para cada estrutura base

    // importe arquivos
    String[] fileName = {"test", "testeSoma"};
    BufferedReader br = new BufferedReader(new FileReader("src/testes/"+fileName[0]+".ura"));

    Lexico lexico = new Lexico();
    //lexico.runLexico(br);

    Sintatico sintatico = new Sintatico();
    // sintatico.runSintatico(br.readLine());
    
    // ler todos arquivos teste
    for (int i = 0; i < fileName.length; i++) {
      BufferedReader brAll = new BufferedReader(new FileReader("src/testes/"+fileName[i]+".ura"));
      System.out.println(fileName[i]+".ura\n");
      
      System.out.println("\nLexico:\n");
      lexico.runLexico(brAll);
      
      // ta certo mas n funciona (excesso eu acho)
      System.out.println("\nSintatico:\n");
      try { 
        while ((brAll.readLine()) != null){
          sintatico.runSintatico(brAll.readLine());
        }
        brAll.close();
      } 
      catch (FileNotFoundException e) {e.printStackTrace();}      
      catch (IOException e) {e.printStackTrace();}
      finally {
        try {
            if (brAll != null) brAll.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      }
      
      System.out.println("\n--------------------------------------------------------------------\n");
    }

    
  }
  
  public static void runTestes(String[] args){

  }
}
