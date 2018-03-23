/**
 * Created by itzhak on 23-Mar-18.
 */
public class Variable implements Node {

    private Context context;
    private Integer id;

    public Variable(Integer id,Context context){
        this.context = context;
        this.id = id;
    }

    @Override
    public Double parse() {
        return context.getVarValue(this.id);
    }





}
