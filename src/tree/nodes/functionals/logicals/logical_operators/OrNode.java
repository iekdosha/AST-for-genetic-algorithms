package tree.nodes.functionals.logicals.logical_operators;

import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class OrNode extends LogicalOperatorNode {
    public OrNode() {
        super(2);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) == 1.0 || this.parseChild(1) == 1.0){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }
    @Override
    public String nodeStr() {
        return "OR";
    }
}
