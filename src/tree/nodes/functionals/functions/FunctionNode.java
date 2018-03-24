package tree.nodes.functionals.functions;

import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.arithmetic_functions.ArithmeticFunctionNode;
import utils.ItemRandomizer;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class FunctionNode extends FunctionalNode {
    public FunctionNode(int childrenNum) {
        super(childrenNum);
    }

    public static FunctionNode randomFunctionNode(){

        HashMap<Class,Integer> map = new HashMap<>();
        map.put(ArithmeticFunctionNode.class,4);
        map.put(IfElseNode.class,4);

        Class c = ItemRandomizer.<Class>rand(map);


        String classPath = c.getCanonicalName();

        try{
            if(c.equals(ArithmeticFunctionNode.class)){
                return ArithmeticFunctionNode.randomArithmeticFunctionNode();
            }
            else{
                return (FunctionNode) c.newInstance();
            }
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }



}
