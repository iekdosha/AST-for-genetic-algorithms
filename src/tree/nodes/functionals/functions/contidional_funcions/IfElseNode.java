package tree.nodes.functionals.functions.contidional_funcions;

import tree.nodes.Context;
import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.factories.node_type_factories.FunctionNodeFactory;
import tree.nodes.factories.node_type_factories.LogicalNodeFactory;
import tree.nodes.leaves.LeafNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class IfElseNode extends ConditionalFunctionNode {



    public IfElseNode() {
        super(3);
        this.setMinDepth(2);
    }

    @Override
    public Double parse(Context context) {
        if(this.parseChild(0,context ) == 1.0){
            return this.parseChild(1,context );
        }
        else{
            return this.parseChild(2, context);
        }

    }

    @Override
    public String nodeStr() {
        return "IF_ELSE";
    }

    public Node randomTree(DepthRestriction restriction) {

        Node logicalNode =  LogicalNodeFactory.getInstance().createRandomNode(restriction.descendMinDepth(2));
        if(logicalNode instanceof LeafNode){
            System.out.println(restriction.descendMinDepth(2));
        }
        this.setChild(0,logicalNode.randomSubTree(restriction.descendMinDepth(2)));
        for(int i = 1 ; i < this.getChildrenNum(); i++){
            Node child = FunctionNodeFactory.getInstance().createRandomNode(restriction);;
            this.setChild(i,child.randomSubTree(restriction.descend()));
        }
        return this;
    }



}
