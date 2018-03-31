package tree.nodes.non_functionals;

import tree.nodes.Context;
import tree.nodes.Node;
import utils.RandUtils;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LeafNode implements Node {

    public static Double weight = 1.0;


    public static Node randomNode(Context context){

        HashMap<Class,Double> map = new HashMap<>();
        map.put(ConstantNode.class,ConstantNode.weight);
        map.put(VariableNode.class,VariableNode.weight);


        Class c = RandUtils.<Class>randItem(map);


        if (c.equals(VariableNode.class)){
            return new VariableNode(context.getRandomVarId(),context);
        }
        else if(c.equals(ConstantNode.class)){
            return ConstantNode.getRandomConstantNode();
        }

        return null;
    }
}
