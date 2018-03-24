package tree.nodes.non_functionals;

import tree.nodes.Context;
import tree.nodes.Node;
import utils.ItemRandomizer;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LeafNode implements Node {


    public static LeafNode randomLeafNode(Context context){

        HashMap<Class,Integer> map = new HashMap<>();
        map.put(ConstantNode.class,1);
        map.put(VariableNode.class,1);


        Class c = ItemRandomizer.<Class>rand(map);


        if (c.equals(VariableNode.class)){
            return new VariableNode(context.getRandomVarId(),context);
        }
        else if(c.equals(ConstantNode.class)){
            return ConstantNode.getRandomConstantNode();
        }

        return null;
    }
}
