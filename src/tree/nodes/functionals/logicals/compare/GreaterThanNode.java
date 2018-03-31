package tree.nodes.functionals.logicals.compare;

import tree.nodes.functionals.logicals.LogicalNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class GreaterThanNode extends CompareNode {

    public static Double weight = 2.0;

    public GreaterThanNode() {
        super(2);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) > this.parseChild(1)){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }

    @Override
    public String nodeStr() {
        return "GT";
    }
}
