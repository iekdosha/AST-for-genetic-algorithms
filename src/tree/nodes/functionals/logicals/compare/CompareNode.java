package tree.nodes.functionals.logicals.compare;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.functionals.logicals.logical_operators.AndNode;
import tree.nodes.functionals.logicals.logical_operators.OrNode;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;

import java.util.HashMap;

/**
 * Created by itzhak on 30-Mar-18.
 */
public abstract class CompareNode extends LogicalNode {

    public static Double weight = 2.0;


    public CompareNode(int childrenNum) {
        super(childrenNum);
    }


    public static FunctionalNode randomNode(){


        return (FunctionalNode) RandUtils.randNodeInstance(
                LessThanNode.class,
                GreaterThanNode.class
        );


    }


    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {

        for(int i = 0 ; i < this.getChildrenNum(); i++){
            FunctionalNode child = FunctionNode.randomNode();
            this.setChild(i,child.maybeLeaf(minDepth -1,maxDepth-1,context));
        }
        return this;
    }

}
