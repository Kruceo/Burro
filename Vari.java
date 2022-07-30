import java.util.List;

public class Vari {

        List<String> arg = null;
        String name = null;
        String result = null;

        public Vari(String name, List<String> arg)
        {
            this.arg = arg;
            this.name = name;
            if(arg.get(1) != null){
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
            
                default:
                    break;
            }
        }
        else
        {
            result = arg.get(0);
        }
    }
}


