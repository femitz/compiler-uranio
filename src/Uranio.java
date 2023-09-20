import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Uranio {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java uranio <input_file.ura>");
            System.exit(1);
        }
        String fileName = args[0];
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}