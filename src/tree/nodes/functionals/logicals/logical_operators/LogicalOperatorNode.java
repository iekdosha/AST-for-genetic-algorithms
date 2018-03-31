package tree.nodes.functionals.logicals.logical_operators;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.functionals.logicals.compare.GreaterThanNode;
import tree.nodes.functionals.logicals.compare.LessThanNode;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LogicalOperatorNode extends LogicalNode {

    public static Double weight = 1.0;


    public static FunctionalNode randomNode(){

        return (FunctionalNode) RandUtils.randNodeInstance(
                AndNode.class,
                OrNode.class
        );



    }

    public LogicalOperatorNode(int childrenNum) {
        super(childrenNum);
        this.setMinDepth(2);
    }

    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {
        for(int i = 0 ; i < this.getChildrenNum(); i++){
            FunctionalNode child = LogicalNode.randomNode();
            this.setChild(i,child.maybeLeaf(1,maxDepth-1,context));
        }
        return this;
    }

}
