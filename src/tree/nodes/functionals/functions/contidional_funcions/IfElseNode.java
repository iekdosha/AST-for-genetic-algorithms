package tree.nodes.functionals.functions.contidional_funcions;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class IfElseNode extends FunctionNode {

    public static Double weight = 1.0;


    public IfElseNode() {
        super(3);
        this.setMinDepth(2);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) == 1.0){
            return this.parseChild(1);
        }
        else{
            return this.parseChild(2);
        }

    }

    @Override
    public String nodeStr() {
        return "IF_ELSE";
    }

    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {


        FunctionalNode logicalNode = LogicalNode.randomNode();
        this.setChild(0,logicalNode.randomTree(1,maxDepth-1,context));
        for(int i = 1 ; i < this.getChildrenNum(); i++){
            FunctionalNode child = FunctionNode.randomNode();
            this.setChild(i,child.maybeLeaf(minDepth-1,maxDepth-1,context));
        }
        return this;
    }



}
