package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.functionals.functions.*;
import tree.nodes.factories.node_type_factories.FunctionNodeFactory;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class ArithmeticFunctionNode extends FunctionNode {


    public ArithmeticFunctionNode() {
        super(2);
    }


    @Override
    public Node randomTree(DepthRestriction restriction) {

        for(int i = 0 ; i < this.getChildrenNum(); i++){

            Node child =  FunctionNodeFactory.getInstance().createRandomNode(restriction);
            this.setChild(i,child.randomSubTree(restriction.descend()));
        }
        return this;
    }


}
