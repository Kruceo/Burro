import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Burro {

    static String cod = "";

    public static void main(String[] args) throws IOException {


        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

            String readerString = null;
            while ((readerString = fileReader.readLine()) != null) {
                cod += readerString;
            }
        } catch (Error e) {
            System.out.println("try 'java Burro yourFile.bur'");
        }

        System.out.println(cod);

        Execute mainExecute
         = new Execute(cod);
        mainExecute.run();
    }

}
