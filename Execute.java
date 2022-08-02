import java.util.ArrayList;
import java.util.List;

public class Execute implements Runnable {

    String cod = "";
    public static List<Vari> varis = new ArrayList<>();

    public Execute(String cod) {
        this.cod = cod;
    }

    @Override
    public void run() {
        String[] codToRows = cod.split(";");
        for (String line : codToRows) {

            String part[] = line.split(" ");

            
            if (part.length > 0) {
                if (part[0].startsWith("if")) {
                    List<String> compareArgs = new ArrayList<>();
                    String accept = "";
                    int i;
                    for (i = 1; i < part.length; i++) {
                        if (part[i].contains("{")) {
                           // System.out.println("break on "+ part[i]);
                            break;
                        }
                        if (part[i].startsWith("@")) {
                            compareArgs.add(getVariFromName(part[i].replace("@", "")).result);
                        } else {
                            compareArgs.add(part[i]);
                        }

                    }
                    for (int y = i; y < part.length; y++) {
                        if (part[y].contains("}")) {
                            //System.out.println("break on "+ part[y]);
                            
                            break;
                        }

                        if (!part[y].contains("{")) {

                            if (accept != "") {
                                accept += " ";
                            }
                            
                            accept += part[y].replace("#", ";");
                            
                        }

                    }


                    //System.out.println("\n"+compareArgs + "\n" + accept);
                    Compare compare = new Compare(compareArgs, accept);
                    compare.run();

                    continue;
                }
                if (part[0].startsWith("while")) {
                    List<String> compareArgs = new ArrayList<>();
                    String accept = "";
                    int i;
                    for (i = 1; i < part.length; i++) {
                        if (part[i].contains("{")) {
                           // System.out.println("break on "+ part[i]);
                            break;
                        }
                        else {
                            compareArgs.add(part[i]);
                        }

                    }
                    
                    for (int y = i; y < part.length; y++) {
                        if (part[y].contains("}")) {
                            //System.out.println("break on "+ part[y]);
                            
                            break;
                        }

                        if (!part[y].contains("{")) {

                            if (accept != "") {
                                accept += " ";
                            }
                            
                            accept += part[y].replace("#", ";");
                            
                        }

                    }


                    //System.out.println("\n"+compareArgs + "\n" + accept);
                    While while1 = new While(compareArgs, accept);
                    while1.run();

                    continue;
                }
                ///System.out.println("\n"+line + " => passou do if " );
                if (part[0].startsWith("@")) {
                    List<String> varArgs = new ArrayList<>();

                    for (int i = 1; i < part.length; i++) {
                        
                        if (part[i].startsWith("@")) {
                            varArgs.add(getVariFromName(part[i].replace("@", "")).result);
                        } else {
                            varArgs.add(part[i]);
                        }
                    }

                    getVariFromName(part[0].replace("@", "")).setArg(varArgs);
                    continue;
                }

                switch (part[0]) { /// create a variable
                    case "vari":
                        List<String> varArgs = new ArrayList<>();

                        for (int i = 2; i < part.length; i++) {
                            if (part[i].startsWith("@")) {
                                varArgs.add(getVariFromName(part[i].replace("@", "")).result);
                            } else {
                                varArgs.add(part[i]);
                            }
                        }

                        Execute.varis.add(new Vari(part[1], varArgs));

                        break;

                    case "printa":
                        System.out.println(); { // print any string
                        for (int i = 1; i < part.length; i++) {
                            if (i != 1) {
                                System.out.print(" ");
                            }
                            if (part[i].startsWith("@")) {
                                System.out.print(getVariFromName(part[i].replace("@", "")).result);
                            } else {
                                System.out.print(part[i]);
                            }
                        }
                    }

                        break;
                    default:
                        System.out.println("\n(EXECUTE ERROR: " + line);
                        break;
                }
            }
        }

    }

    public Vari getVariFromName(String name) {
        // print a var
        for (Vari var : Execute.varis) {
            if (name.replace("@", "").equals(var.name)) {
                return var;
            }

        }
        return null;

    }
}
