import java.util.List;

public class Vari {
    String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
    List<String> arg = null;
    String name = null;
    String result = null;

    public Vari(String name, List<String> arg) {
        this.arg = arg;
        this.name = name;

        calcArgs();

    }

    public boolean isInt(String enter, String[] lookupTable) {
        for (String lookItem : lookupTable) {
            if (enter.contains(lookItem)) {
                return true;
            }
        }
        return false;
    }

    public void setArg(List<String> args) {
        arg = args;

        calcArgs();
    }

    private void calcArgs() {
        if (arg.size() > 0) {

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
                    int res = (int) (Math.pow(Integer.parseInt(arg.get(0)), Integer.parseInt(arg.get(2))));
                    result = String.valueOf(res);
                    break;
                case "%":

                    result = String.valueOf((int) (Integer.parseInt(arg.get(0)) / 100));
                    break;
                default:
                    System.out.println("VARI ERROR:  '" + arg.get(1) + "'");
                    break;
            }

        }
    }
}
