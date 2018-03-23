import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class Context {

    private LinkedHashMap<Integer, Double> vars;
    private final Integer maxNumOfVars;

    public Context(Double... args){
        vars = new LinkedHashMap<>();
        for(int i = 0 ; i < args.length ; i++){
            vars.put(i,args[i]);
        }
        maxNumOfVars = args.length;
    }

    public int getRandomVarId(){
        Random rand = new Random();
        int randomNum = rand.nextInt(maxNumOfVars  + 1);
        return randomNum;
    }

    public Double getVarValue(Integer valId){
        if(vars.containsKey(valId)){
            return vars.get(valId);
        }
        return Double.NaN;
    }



}
