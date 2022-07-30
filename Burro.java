import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Burro {

    public static List<Vari> varis = new ArrayList<>();
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

        // System.out.println("@"+cod);

        String[] codToRows = cod.split(";");
        for (String line : codToRows) {

            String lines[] = line.split(" ");

            switch (lines[0]) {
                case "vari":
                    List<String> varArgs = new ArrayList<>();

                    for (int i = 2; i < lines.length; i++) {
                        if (lines[i].startsWith("@")) {
                            varArgs.add(getVariFromName(lines[i].replace("@", "")).result);
                        } else {
                            varArgs.add(lines[i]);
                        }
                    }

                    varis.add(new Vari(lines[1], varArgs));

                    break;

                case "printa":
                System.out.println();
                    { // print any string
                        for (int i = 1; i < lines.length; i++) {
                            if(i != 1)
                            {
                                System.out.print(" ");
                            }
                            if (lines[i].startsWith("@")) {
                                System.out.print(getVariFromName(lines[i].replace("@", "")).result);
                            } else {
                                System.out.print(lines[i]);
                            }
                        }
                    }

                    break;

                default:
                    System.out.println("error here " + line);
                    break;
            }

        }

    }

    public static Vari getVariFromName(String name) {
        // print a var
        for (Vari var : varis) {
            if (name.replace("@", "").equals(var.name)) {
                return var;
            }

        }
        return null;

    }
}
