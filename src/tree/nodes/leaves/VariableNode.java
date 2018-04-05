package tree.nodes.leaves;

import tree.nodes.Context;

import java.util.Random;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class VariableNode extends LeafNode {

    public static Double weight = 4.0;

    private static Integer idRange = 3;

    private Integer id;


    public VariableNode(Integer id){

        this.id = id;
    }

    public VariableNode(){
        this.id = (new Random()).nextInt(idRange);
    }

    @Override
    public Double parse(Context context) {
        return context.getVarValue(this.id);
    }

    @Override
    public String nodeStr() {
        return "VAR"+id.toString();
    }





}
