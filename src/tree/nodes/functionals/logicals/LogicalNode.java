package tree.nodes.functionals.logicals;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.*;
import tree.nodes.functionals.logicals.logical_operators.AndNode;
import tree.nodes.functionals.logicals.logical_operators.OrNode;
import tree.nodes.non_functionals.LeafNode;
import utils.ItemRandomizer;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LogicalNode extends FunctionalNode {
    public LogicalNode(int childrenNum) {
        super(childrenNum);
    }

    public static LogicalNode randomLogicalNode(){

        HashMap<Class,Integer> map = new HashMap<>();
        map.put(AndNode.class,1);
        map.put(OrNode.class,1);
        map.put(LessThanNode.class,2);
        map.put(GreaterThanNode.class,2);


        Class c = ItemRandomizer.<Class>rand(map);


        String classPath = c.getCanonicalName();

        try{

            return (LogicalNode) c.newInstance();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }



    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {

        Node node;
        if( (Math.random() < 0.5 && minDepth  <= 0) || maxDepth <= 0){
            node = LeafNode.randomLeafNode(context);
        }
        else{
            FunctionNode functionNode = FunctionNode.randomFunctionNode();
            for(int i = 0 ; i < this.getChildrenNum(); i++){
                FunctionNode child = FunctionNode.randomFunctionNode();
                this.setChild(i,child.randomTree(minDepth-1,maxDepth-1,context));
            }
            node = this;
        }
        return node;
    }


}
