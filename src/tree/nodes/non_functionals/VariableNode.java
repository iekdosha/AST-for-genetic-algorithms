package tree.nodes.non_functionals;

import tree.nodes.Context;
import tree.nodes.Node;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class VariableNode extends LeafNode {

    public static Double weight = 4.0;

    private Context context;
    private Integer id;

    public VariableNode(Integer id, Context context){
        this.context = context;
        this.id = id;
    }

    @Override
    public Double parse() {
        return context.getVarValue(this.id);
    }

    @Override
    public String nodeStr() {
        return "VAR"+id.toString();
    }



}
