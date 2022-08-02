import java.util.ArrayList;
import java.util.List;

public class Compare implements Runnable {

    public Compare(List<String> args, String execute) {
        this.args = args;
        this.execute = execute;
    }

    List<String> args = new ArrayList<>();
    String execute = "";

    @Override
    public void run() {

        switch (args.get(1)) {
            case "=":

                if (args.get(0).equals(args.get(2))) {

                    Execute compareExecute = new Execute(execute);
                    compareExecute.run();
                }
                break;

            case "!=":

            
                if (!args.get(0).equals(args.get(2))) {

                    Execute compareExecute = new Execute(execute);
                    compareExecute.run();
                }
                break;

            default:
            System.out.println("deu ruim aqui " + args);
                break;
        }
    }

}
