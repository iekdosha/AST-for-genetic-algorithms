package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.*;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;
import utils.ReflectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class ArithmeticFunctionNode extends FunctionNode {

    public static Double weight = 4.0;

    public ArithmeticFunctionNode() {
        super(2);
    }


    @Override
    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {

        for(int i = 0 ; i < this.getChildrenNum(); i++){
            FunctionalNode child = FunctionNode.randomNode();
            this.setChild(i,child.maybeLeaf(minDepth-1,maxDepth-1,context));
        }
        return this;
    }

    public static FunctionalNode randomNode(){

        return (FunctionalNode) RandUtils.randNodeInstance(
                AddNode.class,
                SubNode.class,
                MulNode.class,
                DivNode.class,
                MinNode.class,
                MaxNode.class
        );


    }


}
