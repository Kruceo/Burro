import java.util.ArrayList;
import java.util.List;

public class While implements Runnable {


    public While(List<String> args, String execute) {
        this.args = args;
        this.execute = execute;
    }

    List<String> args = new ArrayList<>();
    List<String> realArgs = new ArrayList<>();
    String execute = "";
    Execute compareExecute;
    @Override
    public void run() {
        compareExecute = new Execute(execute);
        loadArgs();
        switch (realArgs.get(1)) {
            case "=":

                while (realArgs.get(0).equals(realArgs.get(2))) {

                    compareExecute.run();
                    
                    loadArgs();
                }
                break;

            case "!":

            
                while (!realArgs.get(0).equals(realArgs.get(2))) {
                   
                    compareExecute.run();
                    
                    loadArgs();
                    
                }
                break;

            default:
            System.out.println("WHILE ERROR " + args);
                break;
        }
    }



    public void loadArgs()
    {
        List<String> newList = new ArrayList<>();
        for(String arg : args)
        {
            
            if(arg.startsWith("@"))
            {
                arg = compareExecute.getVariFromName(arg.replace("@", "")).result;
            }
            newList.add(arg);
            
            
        }
        this.realArgs = newList;
        
    }
    
}
