package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.*;
import tree.nodes.non_functionals.LeafNode;
import utils.ItemRandomizer;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class ArithmeticFunctionNode extends FunctionNode {
    public ArithmeticFunctionNode() {
        super(2);
    }


    protected static Double getLeafChance(Integer minDepth, Integer maxDepth){
        Double leafChance = 0.0;
        if(minDepth == 0){
            leafChance = 0.5;
        }
        if(maxDepth == 0){
            leafChance = 1.0;
        }
        return leafChance;
    }

    @Override
    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {


        Node node;
        if((Math.random() < 0.5 && minDepth  <= 0) || maxDepth <= 0){
            node = LeafNode.randomLeafNode(context);
        }
        else{

            for(int i = 0 ; i < this.getChildrenNum(); i++){
                FunctionNode child = FunctionNode.randomFunctionNode();
                this.setChild(i,child.randomTree(minDepth-1,maxDepth-1,context));
            }
            node = this;
        }
        return node;
    }

    public static ArithmeticFunctionNode randomArithmeticFunctionNode(){

        HashMap<Class,Integer> map = new HashMap<>();
        map.put(AddNode.class,1);
        map.put(SubNode.class,1);
        map.put(MulNode.class,1);
        map.put(DivNode.class,1);
        map.put(MinNode.class,1);
        map.put(MaxNode.class,1);

        Class c = ItemRandomizer.<Class>rand(map);


        String classPath = c.getCanonicalName();

        try{

            return (ArithmeticFunctionNode) c.newInstance();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }


}
