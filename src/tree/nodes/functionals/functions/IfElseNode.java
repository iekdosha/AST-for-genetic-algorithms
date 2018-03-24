package tree.nodes.functionals.functions;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.non_functionals.LeafNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class IfElseNode extends FunctionNode {
    public IfElseNode() {
        super(3);
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


        Node node;
        if((Math.random() < 0.5 && minDepth  <= 0) || maxDepth <= 1){
            node = LeafNode.randomLeafNode(context);
        }
        else{

            LogicalNode logicalNode = LogicalNode.randomLogicalNode();
            this.setChild(0,logicalNode.randomTree(1,maxDepth-1,context));
            for(int i = 1 ; i < this.getChildrenNum(); i++){
                FunctionNode child = FunctionNode.randomFunctionNode();
                this.setChild(i,child.randomTree(minDepth-1,maxDepth-1,context));
            }
            node = this;
        }
        return node;
    }


}
