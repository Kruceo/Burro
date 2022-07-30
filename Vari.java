import java.util.List;

public class Vari {

    List<String> arg = null;
    String name = null;
    String result = null;

    public Vari(String name, List<String> arg) {
        this.arg = arg;
        this.name = name;
        if (!arg.get(1).isEmpty()) {
            switch (arg.get(1)) {
                case "+":
                    result = String.valueOf(Integer.parseInt(arg.get(0)) + Integer.parseInt(arg.get(2)));
                    break;
                case "-":
                    result = String.valueOf(Integer.parseInt(arg.get(0)) - Integer.parseInt(arg.get(2)));
                    break;
                case "*":
                    result = String.valueOf(Integer.parseInt(arg.get(0)) * Integer.parseInt(arg.get(2)));
                    break;
                case "/":
                    result = String.valueOf(Integer.parseInt(arg.get(0)) / Integer.parseInt(arg.get(2)));
                    break;

                case "^": 
                    int res = (int)(Math.pow(Integer.parseInt(arg.get(0)), Integer.parseInt(arg.get(2))));
                    result = String.valueOf(res);
                    break;
                default:
                System.out.println("error in '"+arg.get(1)+"'");;
                    break;
            }
        } else {
            result = arg.get(0);
        }
    }
}
