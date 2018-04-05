package tree.nodes.functionals.logicals.logical_operators;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.factories.node_factories.CompareNodeFactory;
import tree.nodes.factories.node_factories.LeafFactory;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.factories.node_type_factories.LogicalNodeFactory;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LogicalOperatorNode extends LogicalNode {




    public LogicalOperatorNode(int childrenNum) {
        super(childrenNum);
        this.setMinDepth(2);
    }

    public Node randomTree(DepthRestriction restriction) {
        for(int i = 0 ; i < this.getChildrenNum(); i++){
            Node child = LogicalNodeFactory.getInstance().createRandomNode(restriction);
            this.setChild(i,child.randomSubTree(restriction.descendMinDepth(2)));
        }
        return this;
    }

    public Node randomSubTree(DepthRestriction restriction){
        if( restriction.getMaxDepth() <= this.getMinDepth()){
            return CompareNodeFactory.getInstance().createRandomNode(restriction).randomSubTree(restriction);
        }
        return this.randomTree(restriction);
    }


}
