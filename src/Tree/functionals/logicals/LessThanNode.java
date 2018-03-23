package Tree.functionals.logicals;

import Tree.functionals.FunctionalNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class LessThanNode extends LogicalNode {
    public LessThanNode() {
        super(2);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) < this.parseChild(1)){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }

    @Override
    public String nodeStr() {
        return "<";
    }
}
