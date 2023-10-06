import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testeAbrirLerArquivo {
  public static void main(String args[]) {
    try {
      File myObj = new File("./test.ura");
      Scanner leitor = new Scanner(myObj);
      while (leitor.hasNextLine()) {
        String dados = leitor.nextLine();
        System.out.println(dados);
      }
      leitor.close();
    } catch (FileNotFoundException e) {
      System.out.println("Um erro ocorreu");
      e.printStackTrace();
    }
  }
}