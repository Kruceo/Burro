import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jay {

   public static List<Vari> varis = new ArrayList<>();

    public static void main(String[] args) {
        String cod = "var rafola 2222 + 2227#printa rafola";

        String[] codToRows = cod.split("#");
        for (String line : codToRows) {

            String lines[] = line.split(" ");

            switch (lines[0]) {
                case "var":
                    List<String> arg = new ArrayList<>();

                    for (int i = 2; i < lines.length; i++) {
                        arg.add(lines[i]);
                    }

                    varis.add(new Vari(lines[1], arg));

                    break;

                case "printa":
                    for (Vari var : varis) {
                        if(var.name.equals(lines[1]))
                        {
                            
                            System.out.println(var.result);
                            break;
                        }

                    }
                    
                    break;

                default:
                    System.out.println("erro de syntax");
                    break;
            }

        }

    }

}
