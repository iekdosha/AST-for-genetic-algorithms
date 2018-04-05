package tree.nodes.functionals.logicals.compare;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.factories.node_type_factories.FunctionNodeFactory;

/**
 * Created by itzhak on 30-Mar-18.
 */
public abstract class CompareNode extends LogicalNode {



    public CompareNode(int childrenNum) {
        super(childrenNum);
    }





    public Node randomTree(DepthRestriction restriction) {

        for(int i = 0 ; i < this.getChildrenNum(); i++){
            Node child = FunctionNodeFactory.getInstance().createRandomNode(restriction);
            this.setChild(i,child.randomSubTree(restriction.descend()));
        }
        return this;
    }

}
