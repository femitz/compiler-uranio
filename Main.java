// linguagem de programação uranio

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) throws FileNotFoundException{

    /// chamar os arquivos e fazer os respectivos testes de lexicos e sintaticos
    /// um arquvo para cada estrutura base

    // importe arquivos
    String[] fileName = {"test", "testeSoma"};
    BufferedReader br = new BufferedReader(new FileReader("src/testes/"+fileName[0]+".ura"));

    Lexico lexico = new Lexico();
    lexico.runLexico(br);

  }
}
