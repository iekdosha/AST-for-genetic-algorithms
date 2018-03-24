package tree.nodes.functionals.logicals.logical_operators;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.non_functionals.LeafNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LogicalOperatorNode extends LogicalNode {
    public LogicalOperatorNode(int childrenNum) {
        super(childrenNum);
    }

    public Node randomTree(Integer minDepth, Integer maxDepth, Context context) {

        Node node;
        if((Math.random() < 0.5 && minDepth  <= 0) || maxDepth <= 0){
            node = LeafNode.randomLeafNode(context);
        }
        else{
            for(int i = 0 ; i < this.getChildrenNum(); i++){
                LogicalNode child = LogicalNode.randomLogicalNode();
                this.setChild(i,child.randomTree(minDepth-1,maxDepth-1,context));
            }
            node = this;
        }
        return node;
    }

}
